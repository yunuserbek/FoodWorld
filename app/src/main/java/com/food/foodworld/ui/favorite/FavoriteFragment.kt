package com.food.foodworld.ui.favorite

import android.content.ClipDescription
import android.os.Bundle
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.food.common.Resource
import com.food.common.model.CategoryDetailUIModel
import com.food.foodworld.databinding.FragmentFavoriteBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private val favoriteAdapter by lazy { FavoriteAdapter(requireActivity(),viewModel) }



    private val viewModel: FavoriteVM by viewModels()

    private lateinit var binding: FragmentFavoriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFavoriteRecipes()
        collectData()
        itemTouchHelper()
        binding.floatingActionButton.setOnDragListener(dragListener)


    }

    private val dragListener = View.OnDragListener { view, event ->
        when(event.action){
            DragEvent.ACTION_DRAG_STARTED -> {
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP ->{
                val item = event.clipData.getItemAt(0)

                val deleteID = item.text.toString().toInt()
               // Toast.makeText(requireContext(), not.toString(), Toast.LENGTH_SHORT).show()

                showDeleteDialog(deleteID)

                true
            }
            DragEvent.ACTION_DRAG_ENDED ->{

                true
            }
            else -> false
        }
    }

    private fun showDeleteDialog(item: Int){
        val builder = MaterialAlertDialogBuilder(this.requireContext())
        builder.setMessage("Are you sure you want to delete this recipe ?")
            .setCancelable(false)
            .setPositiveButton("Yes") { dialog, id ->
            viewModel.deleteRecipeID(item)

            }

            .setNegativeButton("No") { dialog, id ->
                // Dismiss the dialog
                dialog.dismiss()
            }
        val dialog = builder.create()
        dialog.show()
    }


    fun collectData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getAllRecipe.collect {response->

                when (response) {
                    is Resource.Loading -> {

                    }

                    is Resource.Success -> {


                        favoriteAdapter.submitList(response.data)
                        binding.fovoriteRv.adapter = favoriteAdapter
                    }

                    is Resource.Error -> {
                    }
                }

            }
        }
    }

    private fun itemTouchHelper() {
        val swipeHandler = object : SwipeToDeleteCallback(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val task = favoriteAdapter.currentList[viewHolder.layoutPosition]
                viewModel.deleteRecipe(task)

            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(binding.fovoriteRv)
    }

    override fun onDestroy() {
        super.onDestroy()

        favoriteAdapter.clearContextualActionMode()
    }
}
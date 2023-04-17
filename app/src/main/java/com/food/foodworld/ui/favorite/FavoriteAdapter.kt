package com.food.foodworld.ui.favorite


import android.view.ActionMode
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.food.common.model.CategoryDetailUIModel
import com.food.foodworld.R
import com.food.foodworld.databinding.ItemFavoriteRecipeBinding
import com.food.foodworld.utility.glideImage
import com.google.android.material.snackbar.Snackbar


class FavoriteAdapter( private val requireActivity: FragmentActivity,    private val favoriteViewModel: FavoriteVM) :
    ListAdapter<CategoryDetailUIModel, FavoriteAdapter.ViewHolder>(FavoriteItemCallBack()) , ActionMode.Callback {
    private var multiSelection = false
    private var selectedRecipes = arrayListOf<CategoryDetailUIModel>()

    private lateinit var mActionMode: ActionMode
    inner class ViewHolder(private val binding: ItemFavoriteRecipeBinding) :

        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryDetailUIModel) {
            with(binding) {
                itemView.animation =
                    AnimationUtils.loadAnimation(
                        itemView.context,
                        R.anim.favorite_item
                    )
                saveItemStateOnScroll(item,binding)
                foodImage.glideImage(item.image)
                recipeText.text = item.title

                root.setOnLongClickListener {
                    if (!multiSelection) {
                        multiSelection = true
                        requireActivity.startActionMode(this@FavoriteAdapter)
                        applySelection(binding, item)
                        true
                    } else {
                        applySelection(binding, item)
                        true
                    }
                }
            }
        }
    }
    private fun applyActionModeTitle() {
        when (selectedRecipes.size) {
            0 -> {
                mActionMode.finish()
                multiSelection = false
            }
            1 -> {
                mActionMode.title = "${selectedRecipes.size} item selected"
            }
            else -> {
                mActionMode.title = "${selectedRecipes.size} items selected"
            }
        }
    }
    private fun saveItemStateOnScroll(currentRecipe: CategoryDetailUIModel, holder: ItemFavoriteRecipeBinding) {
        if (selectedRecipes.contains(currentRecipe)) {
            changeRecipeStyle(holder, R.color.gray400, R.color.purple_500)
        } else {
            changeRecipeStyle(holder, R.color.green, R.color.colorPrimaryDark)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemFavoriteRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    class FavoriteItemCallBack : DiffUtil.ItemCallback<CategoryDetailUIModel>() {
        override fun areItemsTheSame(
            oldItem: CategoryDetailUIModel, newItem: CategoryDetailUIModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CategoryDetailUIModel, newItem: CategoryDetailUIModel
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
    private fun applyStatusBarColor(color: Int) {
        requireActivity.window.statusBarColor = ContextCompat.getColor(requireActivity, color)
    }
    private fun applySelection(holder: ItemFavoriteRecipeBinding, currentRecipe: CategoryDetailUIModel) {
        if (selectedRecipes.contains(currentRecipe)) {
            selectedRecipes.remove(currentRecipe)
            changeRecipeStyle(holder, R.color.white, R.color.colorPrimary)
            applyActionModeTitle()
        } else {
            selectedRecipes.add(currentRecipe)
            changeRecipeStyle(holder, R.color.colorPrimaryDark, R.color.purple_500)
            applyActionModeTitle()
        }
    }
    private fun changeRecipeStyle(binding: ItemFavoriteRecipeBinding, backgroundColor: Int, strokeColor: Int) {
       binding.root.setBackgroundColor(
            ContextCompat.getColor(requireActivity, backgroundColor)
        )

       binding.root.strokeColor =
            ContextCompat.getColor(requireActivity, strokeColor)
    }
    override fun onCreateActionMode(actionMode: ActionMode?, menu: Menu?): Boolean {
        actionMode?.menuInflater?.inflate(R.menu.recipe_detail_menu, menu)
        mActionMode = actionMode!!
        applyStatusBarColor(R.color.white)
        return true
    }


    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        return true
    }

    override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
       // showSnackBar("${selectedRecipes.size} Recipe/s removed.")
        selectedRecipes.forEach {
            favoriteViewModel.deleteRecipe(it)
        }
        multiSelection = false
        selectedRecipes.clear()
        mode?.finish()
        return true
    }

    override fun onDestroyActionMode(mode: ActionMode?) {
        multiSelection = false
        selectedRecipes.clear()
        applyStatusBarColor(R.color.white)
    }
    fun clearContextualActionMode() {
        if (this::mActionMode.isInitialized) {
            mActionMode.finish()
        }
    }


}
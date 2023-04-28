package com.food.foodworld.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.food.common.Resource
import com.food.foodworld.databinding.FragmentSearchBinding
import com.food.foodworld.utility.ClickedAny
import com.food.foodworld.utility.gone
import com.food.foodworld.utility.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment(), ClickedAny {
    lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        collectData()

    }

    fun initUI() {

        binding.searchImageView.setOnClickListener {
            viewModel.getSearch(
                query = binding.searchEditText.text.toString()
            )
        }
    }

    fun collectData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.search.collect {
                when (it) {
                    is Resource.Loading -> {
                        binding.animLoading.visible()



                    }

                    is Resource.Success -> {
                        binding.animLoading.gone()
                        binding.searchRecyclerView.adapter = SearchAdapter(it.data,this@SearchFragment)
                    }

                    is Resource.Error -> {
                        binding.animLoading.gone()
                        binding.searchRecyclerView.gone()

                    }
                }

            }
        }

    }

    override fun onClickedAny(id: Int?, title: String?) {
findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToCategoryDetailsFragment(id?:0,""))
    }
}
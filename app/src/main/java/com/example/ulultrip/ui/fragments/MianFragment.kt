package com.example.ulultrip.ui.fragments

import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.ulultrip.core.ui.BaseFragment
import com.example.ulultrip.databinding.FragmentMianBinding
import com.example.ulultrip.ui.fragments.adapter.CategoryAdapter
import com.geektech.youtubeapi.core.network.result.Status
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MianFragment : BaseFragment<FragmentMianBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModel()
    private val adapter by lazy { CategoryAdapter() }

    override fun getViewBinding(): FragmentMianBinding = FragmentMianBinding.inflate(layoutInflater)

    override fun observeData() {
        super.observeData()
        setupRecyclerView()
        loadData()
//        viewModel.getTourCategories()
//        viewModel.liveCategories.observe(this) {
//            when (it.status) {
//                Status.SUCCESS -> Log.e("aga", "onCreate: " + it.data)
//
//                Status.ERROR -> Log.e("aga", "LOADING: ")
//
//                Status.LOADING -> Log.e("aga", "LOADING: ")
//            }
//        }
    }

    private fun setupRecyclerView() {
binding.rvCategory.adapter = adapter
    }

    private fun loadData() {
        lifecycleScope.launch {
            viewModel.listData.collect {
                Log.e("aga", "loadData: " + it, )
                adapter.submitData(it)
            }
        }
    }
}

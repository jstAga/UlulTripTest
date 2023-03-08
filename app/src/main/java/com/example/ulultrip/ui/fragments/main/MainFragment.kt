package com.example.ulultrip.ui.fragments.main

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.ulultrip.R
import com.example.ulultrip.core.ui.BaseFragment
import com.example.ulultrip.databinding.FragmentMianBinding
import com.example.ulultrip.ui.fragments.main.adapter.CategoryAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMianBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModel()
    private val adapter by lazy { CategoryAdapter() }
    override fun getViewBinding(): FragmentMianBinding = FragmentMianBinding.inflate(layoutInflater)

    override fun initViews() {
        super.initViews()
        binding.rvCategory.adapter = adapter
    }
    override fun observeData() {
        super.observeData()
        loadData()

        binding.btnToursFragment.setOnClickListener { findNavController().navigate(R.id.toursFragment) }
    }


    private fun loadData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.listData.collect {
                    Log.e("aga", "loadData: " + it)
                    adapter.submitData(it)
                }
            }
        }
    }
}
package com.example.ulultrip.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.rickandmortytest.core.ui.BaseViewModel

abstract class BaseFragment<VBinding : ViewBinding, ViewModel : BaseViewModel> : Fragment() {

    protected abstract val viewModel: ViewModel
//    protected abstract fun getViewModelClass(): Class<ViewModel>

    protected lateinit var binding: VBinding
    protected abstract fun getViewBinding(): VBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeData()
        observeView()
    }

    open fun initViews() {}

    open fun observeView() {}

    open fun observeData() {}

    private fun init() {
        binding = getViewBinding()
//        viewModel = ViewModelProvider(this)[getViewModelClass()]
    }
}




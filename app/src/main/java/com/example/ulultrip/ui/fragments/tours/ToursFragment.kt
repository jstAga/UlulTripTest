package com.example.ulultrip.ui.fragments.tours

import android.util.Log
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.ulultrip.core.ui.BaseFragment
import com.example.ulultrip.data.model.FilterModel
import com.example.ulultrip.data.model.TourModel
import com.example.ulultrip.databinding.FragmentToursBinding
import com.example.ulultrip.ui.fragments.tours.adapter.ToursAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ToursFragment : BaseFragment<FragmentToursBinding, ToursViewModel>() {
    override val viewModel: ToursViewModel by viewModel()
    override fun getViewBinding(): FragmentToursBinding = FragmentToursBinding.inflate(layoutInflater)
    private val adapter by lazy { ToursAdapter(this::onItemClick) }
    private val filter = FilterModel()

    override fun initViews() {
        super.initViews()
        binding.rvTours.adapter = adapter
    }

    override fun observeView() {
        super.observeView()
        binding.etDuration.doAfterTextChanged { it1 ->
            filter.duration = it1.toString()

            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.getTours2(filter)
                    adapter.refresh()
                }
            }

        }
    }
    //7 - 12, 14, 20, 29, 31 ,32, 33

    override fun observeData() {
        super.observeData()
        loadData()
        initSubscribers()
    }

    private fun loadData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getTours2(filter)
            }
        }
    }

    private fun initSubscribers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getToursState.collectLatest { state ->
                    when (state) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {}
                        is UIState.Loading -> {}
                        is UIState.Success -> adapter.submitData(state.data)
                    }
                }
            }
        }
    }

    private fun onItemClick(model: TourModel) {
        Log.e("aga", "onItemClick: " + model.id)
    }
}
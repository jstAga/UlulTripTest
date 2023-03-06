package com.example.ulultrip.ui.fragments.tours

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.rickandmortytest.core.ui.BaseViewModel
import com.example.ulultrip.data.model.FilterModel
import com.example.ulultrip.data.model.TourModel
import com.example.ulultrip.data.remote.ApiService
import com.example.ulultrip.ui.fragments.tours.repository.ToursRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ToursViewModel(private val apiService: ApiService, private val repository: ToursRepository) :
    BaseViewModel() {

    private val _getToursState = MutableStateFlow<UIState<PagingData<TourModel>>>(UIState.Empty())
    val getToursState = _getToursState.asStateFlow()

     fun getTours2(filter: FilterModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getTours(filter).collect() {
                _getToursState.value = UIState.Success(it)
            }
        }
    }
}

sealed class UIState<T> {
    class Loading<T> : UIState<T>()
    class Success<T>(val data: T) : UIState<T>()
    class Error<T>(val message: String) : UIState<T>()
    class Empty<T> : UIState<T>()
}
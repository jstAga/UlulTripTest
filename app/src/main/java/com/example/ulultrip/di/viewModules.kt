package com.example.ulultrip.di

import com.example.ulultrip.ui.fragments.main.MainViewModel
import com.example.ulultrip.ui.fragments.tours.ToursViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {
    viewModel { MainViewModel(get()) }
    viewModel { ToursViewModel(get(), get()) }
}
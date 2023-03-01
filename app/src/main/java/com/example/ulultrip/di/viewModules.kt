package com.example.ulultrip.di

import com.example.ulultrip.ui.fragments.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {
    viewModel { MainViewModel(get()) }
}
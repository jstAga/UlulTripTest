package com.example.ulultrip.di

import com.example.ulultrip.ui.fragments.main.repository.MainRepository
import com.example.ulultrip.ui.fragments.tours.repository.ToursRepository
import org.koin.dsl.module

val repoModules = module {
    single { MainRepository(get()) }
    single { ToursRepository(get()) }
}
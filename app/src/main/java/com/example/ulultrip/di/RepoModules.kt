package com.example.ulultrip.di

import com.example.ulultrip.ui.fragments.repository.TestTepository
import org.koin.dsl.module

val repoModules = module {
    single { TestTepository(get()) }
}
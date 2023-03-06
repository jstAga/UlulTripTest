package com.example.ulultrip.di

import com.example.ulultrip.core.network.networkModules
import com.example.ulultrip.data.testDataSource


val koinModules = listOf(
    viewModules,
    repoModules,
    testDataSource,
    networkModules
)


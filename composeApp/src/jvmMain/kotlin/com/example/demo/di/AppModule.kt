package com.example.demo.di

import com.example.demo.AppViewModel
import com.example.demo.Greeting
import org.koin.dsl.module

val appModule = module {
    single { Greeting() }
    factory { AppViewModel(get()) }
}

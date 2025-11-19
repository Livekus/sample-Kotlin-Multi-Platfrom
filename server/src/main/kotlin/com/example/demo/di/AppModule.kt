package com.example.demo.di

import com.example.demo.repository.UserRepository
import org.koin.dsl.module

val appModule = module {
    single { UserRepository() }
}

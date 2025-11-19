package com.example.demo.di

import org.koin.core.context.startKoin

actual object DI {
    private var started = false

    actual fun initKoin() {
        if (started) return
        startKoin {
            modules(appModule)
        }
        started = true
    }
}

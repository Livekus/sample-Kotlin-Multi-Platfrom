package com.example.demo

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.demo.di.DI

fun main() = application {
    // Start Koin for DI
    DI.initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "demo",
    ) {
        App()
    }
}
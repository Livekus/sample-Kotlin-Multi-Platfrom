package com.example.demo

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.example.demo.di.DI

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    // Start Koin for DI on web
    DI.initKoin()
    ComposeViewport {
        App()
    }
}
package com.example.demo

import androidx.compose.ui.window.ComposeUIViewController
import com.example.demo.di.DI
import platform.UIKit.UIViewController

fun MainViewController() : UIViewController {
    // Start Koin for DI on iOS
    DI.initKoin()
    return ComposeUIViewController { App() }
}
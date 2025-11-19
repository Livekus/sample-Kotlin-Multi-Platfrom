package com.example.demo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * Simple ViewModel used by App composable in commonMain.
 * Holds UI state and exposes actions.
 */
class AppViewModel(
    private val greetingProvider: Greeting
) : ViewModel() {
    // UI state
    var showContent by mutableStateOf(false)
        private set

    // Expensive greeting can be computed once and retained in VM
    val greeting: String by lazy { greetingProvider.greet() }

    fun onToggleClick() {
        showContent = !showContent
    }

    // Convenience no-arg constructor for environments without DI
    constructor() : this(Greeting())
}

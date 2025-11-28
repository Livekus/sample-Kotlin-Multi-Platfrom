package com.example.demo.feature.style

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Shared style controller so that style changes in the feature screen
 * are reflected in the core page (and anywhere else) instantly.
 */
object StyleController {
    var altStyle: Boolean by mutableStateOf(false)
        private set

    fun toggle() { altStyle = !altStyle }

    fun applyAltStyle(value: Boolean) { altStyle = value }
}

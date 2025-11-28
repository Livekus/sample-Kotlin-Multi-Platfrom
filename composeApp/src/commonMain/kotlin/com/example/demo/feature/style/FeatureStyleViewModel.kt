package com.example.demo.feature.style

import androidx.lifecycle.ViewModel

/**
 * ViewModel for the style feature. Proxies state to the shared StyleController
 * so changes reflect across the whole app (core page included).
 */
class FeatureStyleViewModel : ViewModel() {
    val altStyle: Boolean get() = StyleController.altStyle

    fun toggleStyle() {
        StyleController.toggle()
    }
}

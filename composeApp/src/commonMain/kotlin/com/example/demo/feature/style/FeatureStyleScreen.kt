package com.example.demo.feature.style

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FeatureStyleScreen(onBack: () -> Unit) {
    val vm: FeatureStyleViewModel = run {
        val owner = LocalViewModelStoreOwner.current
        if (owner != null) viewModel() else remember { FeatureStyleViewModel() }
    }

    val featureColorScheme = if (vm.altStyle) {
        lightColorScheme(
            primary = Color(0xFF005D57),
            onPrimary = Color(0xFFFFFFFF),
            primaryContainer = Color(0xFF97F0EA),
            onPrimaryContainer = Color(0xFF00201E),
            secondary = Color(0xFF4A635F),
            onSecondary = Color(0xFFFFFFFF),
            background = Color(0xFFF6FBFA),
            onBackground = Color(0xFF191C1B),
        )
    } else {
        lightColorScheme()
    }

    MaterialTheme(colorScheme = featureColorScheme) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = onBack) { Text("Back") }
            Button(onClick = { vm.toggleStyle() }) {
                val label = if (vm.altStyle) "Switch to Default Style" else "Switch to Alt Style"
                Text(label)
            }
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Feature: Style toggle screen")
                val current = if (vm.altStyle) "Alt" else "Default"
                Text("Current style: $current")
            }
        }
    }
}

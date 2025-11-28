package com.example.demo.core.presenter

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.example.demo.core.presenter.viewmodel.AppViewModel
import com.example.demo.core.presenter.di.DI
import com.example.demo.feature.style.StyleController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import demo.composeapp.generated.resources.Res
import demo.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    // Local navigation state to open the style feature screen
    var showFeatureStyle by remember { mutableStateOf(false) }

    // Use shared style controller so style changes in feature reflect here
    val altStyle = StyleController.altStyle
    val appColorScheme = if (altStyle) {
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

    MaterialTheme(colorScheme = appColorScheme) {
        val vm: AppViewModel = run {
            // Prefer DI-provided ViewModel when available (e.g., Desktop/JVM, Android, iOS)
            val injected = remember { DI.getAppViewModelOrNull() }
            if (injected != null) {
                injected
            } else {
                val owner = LocalViewModelStoreOwner.current
                if (owner != null) {
                    // Platforms with lifecycle owner (e.g., Android) – use androidx ViewModel
                    viewModel<AppViewModel>()
                } else {
                    // No DI and no owner (e.g., web/preview) – last resort local instance
                    remember { AppViewModel() }
                }
            }
        }
        if (showFeatureStyle) {
            // Show the separated feature UI
            com.example.demo.feature.style.FeatureStyleScreen(onBack = { showFeatureStyle = false })
        } else {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .safeContentPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // Entry point to the feature from core UI
                Button(onClick = { showFeatureStyle = true }) { Text("Feature1") }

                // Core UI content and behavior remains
                Button(onClick = { vm.onToggleClick() }) { Text("Toggle Content") }
                AnimatedVisibility(visible = vm.showContent) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(painterResource(Res.drawable.compose_multiplatform), null)
                        Text("Compose: ${vm.greeting}")
                    }
                }
            }
        }
    }
}
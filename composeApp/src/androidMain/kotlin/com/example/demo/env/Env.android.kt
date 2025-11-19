package com.example.demo.env

import com.example.demo.BuildConfig

actual object Env {
    actual val baseUrl: String = BuildConfig.BASE_URL
}

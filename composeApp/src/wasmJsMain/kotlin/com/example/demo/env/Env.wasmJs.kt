package com.example.demo.env

actual object Env {
    // Wasm apps typically run from same origin; fallback to localhost
    actual val baseUrl: String = "http://127.0.0.1:8080"
}

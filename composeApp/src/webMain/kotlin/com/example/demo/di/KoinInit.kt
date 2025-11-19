package com.example.demo.di

// Web (JS + Wasm) stub DI: no Koin on web to keep dependencies wasm-compatible
actual object DI {
    actual fun initKoin() {
        // no-op on web
    }
}

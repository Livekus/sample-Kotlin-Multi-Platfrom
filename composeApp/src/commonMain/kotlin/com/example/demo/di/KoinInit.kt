package com.example.demo.di

// Multiplatform declaration; platform-specific actual implementations live in
// androidMain, jvmMain, iosMain, and webMain.
expect object DI {
    fun initKoin()
}

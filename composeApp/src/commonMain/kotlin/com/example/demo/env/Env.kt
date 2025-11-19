package com.example.demo.env

/**
 * Environment configuration shared API.
 * Each platform provides its own actual implementation.
 */
expect object Env {
    val baseUrl: String
}

package com.example.demo.env

import com.example.demo.SERVER_PORT

actual object Env {
    actual val baseUrl: String = "http://localhost:$SERVER_PORT"
}

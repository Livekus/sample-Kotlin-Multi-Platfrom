package com.example.demo.user

import com.example.demo.model.User
import com.example.demo.model.UserRequest
import kotlinx.coroutines.flow.Flow

/**
 * Application use cases for User feature using Flow.
 */
class UserUsecase(
    private val repository: UserRepository
) {
    fun listUsers(): Flow<List<User>> = repository.getUsers()
    fun getUser(id: Long): Flow<User?> = repository.getUser(id)
    fun createUser(name: String, email: String): Flow<User> =
        repository.createUser(UserRequest(name = name, email = email))

    fun updateUser(id: Long, name: String, email: String): Flow<User?> =
        repository.updateUser(id, UserRequest(name = name, email = email))

    fun deleteUser(id: Long): Flow<Boolean> = repository.deleteUser(id)
}

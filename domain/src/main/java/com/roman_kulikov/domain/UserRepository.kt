package com.roman_kulikov.domain

import arrow.core.Either

interface UserRepository {
    suspend fun auth(email: String, password: String): Either<AuthError, Boolean>
    suspend fun register(email: String, password: String): Either<AuthError, Boolean>
}
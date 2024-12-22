package com.roman_kulikov.domain

import javax.inject.Inject

class AuthUseCase @Inject constructor(val userRepository: UserRepository) {
    suspend operator fun invoke(email: String, password: String) = userRepository.auth(email = email, password = password)
}
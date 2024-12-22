package com.roman_kulikov.domain.auth_use_cases

import arrow.core.Either
import com.roman_kulikov.domain.AuthError
import com.roman_kulikov.domain.UserRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(email: String, password: String): Either<AuthError, Boolean> {
        return if (AuthValidator.validate(email, password)) {
            userRepository.auth(email = email, password = password)
        } else {
            Either.Left(AuthError.InvalidInputData)
        }


    }
}
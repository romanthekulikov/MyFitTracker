package com.roman_kulikov.domain

sealed class AuthError {
    data object InvalidInputData : AuthError()
    data object InvalidCredentials : AuthError()
    data object UserAlreadyExist : AuthError()
    data object ServiceUnavailable : AuthError()
    data object Unidentified : AuthError()
}
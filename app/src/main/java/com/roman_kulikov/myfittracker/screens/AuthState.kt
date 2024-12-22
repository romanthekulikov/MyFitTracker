package com.roman_kulikov.myfittracker.screens

import com.roman_kulikov.myfittracker.screens.base.BaseState

data class AuthState(
    val email: String = "",
    val password: String = "",
    val isRegistration: Boolean = false,
    override val message: String = "",
) : BaseState() {
    override operator fun invoke() = AuthState()
}

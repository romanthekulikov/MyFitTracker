package com.roman_kulikov.myfittracker.screens

import androidx.lifecycle.viewModelScope
import com.roman_kulikov.domain.AuthUseCase
import com.roman_kulikov.myfittracker.screens.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    val authUseCase: AuthUseCase
) : BaseViewModel<AuthState>(CoroutineScope(Dispatchers.IO + SupervisorJob())) {
    override val _state: MutableStateFlow<AuthState> = MutableStateFlow(AuthState())

    fun setPassword(password: String) = _state.update { it.copy(password = password) }
    fun setEmail(email: String) = _state.update { it.copy(email = email) }
    fun updateMode() = _state.update { it.copy(isRegistration = !it.isRegistration) }

    fun auth() {
        viewModelScope.launch {
            val either = authUseCase(state.value.email, state.value.password)
            if (either.isLeft()) {
                _state.update { it.copy(message = either.leftOrNull() ?: "") }
            }
        }

    }
}
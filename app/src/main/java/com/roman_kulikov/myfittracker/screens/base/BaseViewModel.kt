package com.roman_kulikov.myfittracker.screens.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<T: BaseState> : ViewModel {
    protected abstract val _state: MutableStateFlow<T>
    val state: StateFlow<T> by lazy { _state.asStateFlow() }

    constructor() : super()
    constructor(viewModelScope: CoroutineScope) : super(viewModelScope)
    constructor(vararg closeables: AutoCloseable) : super(*closeables)
    constructor(viewModelScope: CoroutineScope, vararg closeables: AutoCloseable) : super(viewModelScope, *closeables)


}
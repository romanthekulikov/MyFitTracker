package com.roman_kulikov.myfittracker.screens.base

abstract class BaseState {
    abstract val message: String
    abstract operator fun invoke(): BaseState
}
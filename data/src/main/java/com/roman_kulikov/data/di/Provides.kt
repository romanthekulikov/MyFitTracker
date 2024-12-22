package com.roman_kulikov.data.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.roman_kulikov.data.Catcher
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    fun getAuth() = Firebase.auth

    @Provides
    fun getCatcher() = Catcher()
}
package com.roman_kulikov.data.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.roman_kulikov.data.AuthCatcher
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class MainModule {
    @Provides
    fun getAuth() = Firebase.auth

    @Provides
    @Reusable
    fun getCatcher() = AuthCatcher()
}
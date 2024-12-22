package com.roman_kulikov.data.di

import com.roman_kulikov.data.UserRepositoryImplementation
import com.roman_kulikov.domain.UserRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface BindModule {
    @Binds
    @Singleton
    fun bindUserRepository(userRepositoryImplementation: UserRepositoryImplementation): UserRepository
}
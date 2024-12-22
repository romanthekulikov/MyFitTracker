package com.roman_kulikov.data

import arrow.core.Either
import com.google.firebase.auth.FirebaseAuth
import com.roman_kulikov.domain.AuthError
import com.roman_kulikov.domain.UserRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepositoryImplementation @Inject constructor(val firebaseAuth: FirebaseAuth) : UserRepository {
    @Inject lateinit var catcher: AuthCatcher

    override suspend fun auth(email: String, password: String): Either<AuthError, Boolean> {
        return catcher.lunchWithCatch {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            true
        }
    }

    override suspend fun register(email: String, password: String): Either<AuthError, Boolean> {
        return catcher.lunchWithCatch {
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            true
        }
    }
}
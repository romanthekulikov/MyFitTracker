package com.roman_kulikov.data

import arrow.core.Either
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.roman_kulikov.domain.AuthError

class AuthCatcher : Cather<AuthError> {
    override suspend fun <T> lunchWithCatch(job: suspend () -> T): Either<AuthError, T> {
        return try {
            Either.Right(job())
        } catch (e: FirebaseAuthUserCollisionException) {
            Either.Left(AuthError.UserAlreadyExist)
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            Either.Left(AuthError.InvalidCredentials)
        } catch (e: FirebaseNetworkException) {
            Either.Left(AuthError.ServiceUnavailable)
        } catch (e: Exception) {
            Either.Left(AuthError.Unidentified)
        }
    }

    override fun <T> withCatch(job: () -> T): Either<AuthError, T> {
        return try {
            Either.Right(job())
        } catch (e: FirebaseAuthUserCollisionException) {
            Either.Left(AuthError.UserAlreadyExist)
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            Either.Left(AuthError.InvalidCredentials)
        } catch (e: FirebaseNetworkException) {
            Either.Left(AuthError.ServiceUnavailable)
        } catch (e: Exception) {
            Either.Left(AuthError.Unidentified)
        }
    }
}
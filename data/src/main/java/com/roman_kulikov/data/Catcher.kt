package com.roman_kulikov.data

import arrow.core.Either
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException

class Catcher {
    suspend fun <T> lunchWithCatch(job: suspend () -> T): Either<String, T> {
        return try {
            Either.Right(job())
        } catch (e: FirebaseAuthUserCollisionException) {
            Either.Left("Пользователь уже создан")
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            Either.Left("Введен неверный пароль или почта")
        } catch (e: FirebaseNetworkException) {
            Either.Left("Отсутствует соединение")
        } catch (e: FirebaseException) {
            Either.Left("Неопознанная ошибка")
        }
    }

    fun <T> withCatch(job: () -> T): Either<String, T> {
        return try {
            Either.Right(job())
        } catch (e: FirebaseAuthUserCollisionException) {
            Either.Left("Пользователь уже создан")
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            Either.Left("Введен неверный пароль или почта")
        } catch (e: FirebaseNetworkException) {
            Either.Left("Отсутствует соединение")
        } catch (e: FirebaseException) {
            Either.Left("Неопознанная ошибка")
        }
    }
}
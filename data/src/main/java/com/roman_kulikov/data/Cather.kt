package com.roman_kulikov.data

import arrow.core.Either

/**
 * Catcher is required to catch exceptions in one place.
 *
 * @param E type for error handling
 * @param T is out data type
 *
 * [Cather.lunchWithCatch] for suspend job
 *
 * [Cather.withCatch] for inline job
 * */
interface Cather<E> {
    suspend fun <T> lunchWithCatch(job: suspend () -> T): Either<E, T>
    fun <T> withCatch(job: () -> T): Either<E, T>
}
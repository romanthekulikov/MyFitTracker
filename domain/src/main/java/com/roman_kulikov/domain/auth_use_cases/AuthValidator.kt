package com.roman_kulikov.domain.auth_use_cases

import java.util.regex.Pattern

object AuthValidator {
    private val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun validate(email: String, password: String): Boolean {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches() && password.length > 6
    }
}
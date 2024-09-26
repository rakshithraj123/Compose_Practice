package com.app.investcalculator

class LoginValidator {
    fun isValidUsername(username: String): Boolean {
        return username.isNotEmpty() && username.length >= 6
    }

}
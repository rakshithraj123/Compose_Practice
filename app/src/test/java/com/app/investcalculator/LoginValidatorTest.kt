package com.app.investcalculator

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


class LoginValidatorTest {

    private lateinit var loginValidator: LoginValidator

    @org.junit.jupiter.api.BeforeEach
    fun setUp() {
        loginValidator = LoginValidator()
    }

    @Test
    fun `username should be invalid when it is empty`() {
        val result = loginValidator.isValidUsername("")
        assertFalse(result)  // This should fail initially
    }

    @Test
    fun `username should be valid when it is not empty and has more than 5 characters`() {
        val result = loginValidator.isValidUsername("android")
        assertTrue(result)  // Expect this to fail initially
    }

    @org.junit.jupiter.api.AfterEach
    fun tearDown() {
    }
}
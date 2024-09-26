package com.app.investcalculator.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Investment(val name : String = "" , val details : String = "")

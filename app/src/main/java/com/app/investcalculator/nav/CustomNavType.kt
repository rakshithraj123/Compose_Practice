package com.app.investcalculator.nav

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.app.investcalculator.data.model.Investment
import kotlinx.serialization.KSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

//object CustomNavType {
//
//    val InvestmentType = object : NavType<Investment>(
//        isNullableAllowed = false
//    ) {
//        override fun get(bundle: Bundle, key: String): Investment? {
//            return Json.decodeFromString(bundle.getString(key) ?: return null)
//        }
//
//        override fun parseValue(value: String): Investment {
//            return Json.decodeFromString(Uri.decode(value))
//        }
//
//        override fun serializeAsValue(value: Investment): String {
//            return Uri.encode(Json.encodeToString(value))
//        }
//
//        override fun put(bundle: Bundle, key: String, value: Investment) {
//            bundle.putString(key, Json.encodeToString(value))
//        }
//    }
//}

class CustomNavType<T : Any>(private val serializer: KSerializer<T>) :
    NavType<T>(isNullableAllowed = false) {

    override fun get(bundle: Bundle, key: String): T? {
        return bundle.getString(key)?.let {
            Json.decodeFromString(serializer, it)
        }
    }

    override fun parseValue(value: String): T {
        return Json.decodeFromString(serializer, Uri.decode(value))
    }

    override fun serializeAsValue(value: T): String {
        return Uri.encode(Json.encodeToString(serializer, value))
    }

    override fun put(bundle: Bundle, key: String, value: T) {
        bundle.putString(key, Json.encodeToString(serializer, value))
    }

    companion object
}
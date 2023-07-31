package com.icompany.commonnetwork.util

import com.puls.stateutil.Result
import retrofit2.HttpException

suspend fun <T> safeApiCall(call: suspend () -> Result<T>): Result<T> {
    return try {
        call()
    } catch (ex: Exception) {
        return when (ex) {
            is HttpException -> Result.Error(ex.code(), ex.message())
            else -> Result.Failure(ex)
        }
    }
}
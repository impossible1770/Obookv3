package com.puls.home_domain.data.api

import com.puls.home_domain.data.model.response.UserResponse
import retrofit2.http.GET

internal interface HomeApi {

    @GET(HomeNetworkConstants.USERS)
    suspend fun getUsers(): List<UserResponse>
}
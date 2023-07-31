package com.icompany.profile_domain.data.repository

import com.icompany.profile_domain.domain.model.request.UserPageRequest
import com.icompany.profile_domain.domain.model.response.User
import com.puls.stateutil.Result

internal interface UsersRepository {

    suspend fun getPageOfUsersList(userPageRequest: UserPageRequest): Result<List<User>>

    suspend fun getUserById(userId: String): Result<User>
}
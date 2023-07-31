package com.puls.home_domain.data.repository.users

import com.puls.commonnetwork.util.safeApiCall
import com.puls.home_domain.data.api.HomeApi
import com.puls.home_domain.data.mapper.UsersResponseToUsersMapper
import com.puls.home_domain.domain.model.response.User
import com.puls.stateutil.Result
import javax.inject.Inject

internal class UsersRepositoryImpl @Inject constructor(
    private val api: HomeApi,
    private val usersResponseToUsersMapper: UsersResponseToUsersMapper,
) : UsersRepository {

    override suspend fun getUsers(): Result<List<User>> = safeApiCall {
        Result.Success(usersResponseToUsersMapper(api.getUsers()))
    }
}
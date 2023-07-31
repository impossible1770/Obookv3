package com.puls.profile_domain.data.repository

import com.puls.commonnetwork.util.safeApiCall
import com.puls.profile_domain.data.api.ProfileApi
import com.puls.profile_domain.data.mapper.UsersResponseToUsersMapper
import com.puls.profile_domain.domain.model.request.UserPageRequest
import com.puls.profile_domain.domain.model.response.User
import com.puls.profile_domain.mapper.domaintoremote.UserResponseToUserMapper
import com.puls.profile_domain.mapper.domaintoremote.UsersPageRequestToUserRequestMapper
import com.puls.stateutil.Result
import javax.inject.Inject

internal class UsersRepositoryImpl @Inject constructor(
    private val api: ProfileApi,
    private val usersResponseToUsersMapper: UsersResponseToUsersMapper,
    private val userResponseToUserMapper: UserResponseToUserMapper,
    private val usersPageRequestToUserRequestMapper: UsersPageRequestToUserRequestMapper,
) : UsersRepository {

    override suspend fun getPageOfUsersList(userPageRequest: UserPageRequest): Result<List<User>> =
        safeApiCall {
            val request = usersPageRequestToUserRequestMapper(userPageRequest)
            Result.Success(
                usersResponseToUsersMapper(
                    api.getUsersPaginate(
                        pageNumber = request.pageNumber,
                        limit = request.limit
                    )
                )
            )
        }

    override suspend fun getUserById(userId: String): Result<User> = safeApiCall {
        Result.Success(userResponseToUserMapper(api.getUserDetails(userId)))
    }
}
package com.icompany.profile_domain.mapper.domaintoremote

import com.icompany.profile_domain.data.model.request.UserDataRequest
import com.icompany.profile_domain.domain.model.request.UserPageRequest
import javax.inject.Inject

internal class UsersPageRequestToUserRequestMapper @Inject constructor() :
    (UserPageRequest) -> UserDataRequest {

    override fun invoke(userPageRequest: UserPageRequest) = UserDataRequest(
        pageNumber = userPageRequest.page,
        limit = userPageRequest.limit
    )
}
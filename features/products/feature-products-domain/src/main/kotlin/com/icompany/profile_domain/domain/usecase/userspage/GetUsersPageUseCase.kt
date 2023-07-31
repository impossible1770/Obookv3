package com.icompany.profile_domain.domain.usecase.userspage

import com.icompany.profile_domain.domain.model.request.UserPageRequest
import com.icompany.profile_domain.domain.model.response.User
import com.puls.stateutil.Result

interface GetUsersPageUseCase {

    suspend operator fun invoke(userPageRequest: UserPageRequest): Result<List<User>>
}
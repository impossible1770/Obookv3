package com.icompany.profile_domain.domain.usecase.getuser

import com.icompany.profile_domain.domain.model.response.User
import com.puls.stateutil.Result

interface GetUserByIdUseCase {

    suspend operator fun invoke(userId: String): Result<User>
}
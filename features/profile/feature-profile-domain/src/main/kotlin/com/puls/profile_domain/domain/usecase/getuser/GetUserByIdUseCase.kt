package com.puls.profile_domain.domain.usecase.getuser

import com.puls.profile_domain.domain.model.response.User
import com.puls.stateutil.Result

interface GetUserByIdUseCase {

    suspend operator fun invoke(userId: String): Result<User>
}
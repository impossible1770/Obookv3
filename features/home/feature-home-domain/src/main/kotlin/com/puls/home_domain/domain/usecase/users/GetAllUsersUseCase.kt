package com.puls.home_domain.domain.usecase.users

import com.puls.home_domain.domain.model.response.User
import com.puls.stateutil.Result

interface GetAllUsersUseCase {

    suspend operator fun invoke(): Result<List<User>>
}
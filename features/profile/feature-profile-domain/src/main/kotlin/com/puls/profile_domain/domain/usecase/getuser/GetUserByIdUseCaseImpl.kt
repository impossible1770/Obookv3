package com.puls.profile_domain.domain.usecase.getuser

import com.puls.profile_domain.data.repository.UsersRepository
import com.puls.profile_domain.domain.model.response.User
import com.puls.stateutil.Result
import javax.inject.Inject

internal class GetUserByIdUseCaseImpl @Inject constructor(
    private val usersRepository: UsersRepository,
) : GetUserByIdUseCase {

    override suspend fun invoke(userId: String): Result<User> =
        usersRepository.getUserById(userId)
}
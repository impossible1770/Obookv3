package com.icompany.profile_domain.domain.usecase.userspage

import com.icompany.profile_domain.data.repository.UsersRepository
import com.icompany.profile_domain.domain.model.request.UserPageRequest
import javax.inject.Inject

internal class GetUsersPageUseCaseImpl @Inject constructor(
    private val usersRepository: UsersRepository,
) : GetUsersPageUseCase {

    override suspend fun invoke(userPageRequest: UserPageRequest) =
        usersRepository.getPageOfUsersList(userPageRequest)
}
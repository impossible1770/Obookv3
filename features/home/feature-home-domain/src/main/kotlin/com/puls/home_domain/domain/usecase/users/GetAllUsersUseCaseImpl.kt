package com.puls.home_domain.domain.usecase.users

import com.puls.home_domain.data.repository.users.UsersRepository
import javax.inject.Inject

internal class GetAllUsersUseCaseImpl @Inject constructor(
    private val usersRepository: UsersRepository
) : GetAllUsersUseCase {

    override suspend operator fun invoke() = usersRepository.getUsers()
}
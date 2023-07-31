package com.puls.profile.presentation.ui.screen.first

import androidx.lifecycle.viewModelScope
import com.puls.profile_domain.domain.model.request.UserPageRequest
import com.puls.profile_domain.domain.model.response.User
import com.puls.profile_domain.domain.usecase.userspage.GetUsersPageUseCase
import com.puls.stateutil.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class FirstProfileViewModelImpl @Inject constructor(
    private val getUsersPageUseCase: GetUsersPageUseCase,
) : FirstProfileViewModel() {

    override val usersFlow: MutableStateFlow<Result<List<User>>> =
        MutableStateFlow(Result.Loading(false))

    override fun fetchContent() {
        viewModelScope.launch {
            usersFlow.value = Result.Loading(true)
            usersFlow.value = getUsersPageUseCase(
                UserPageRequest(
                    page = MOCK_PAGE,
                    limit = MOCK_LIMIT
                )
            )
        }
    }

    private companion object {
        const val MOCK_PAGE = 1
        const val MOCK_LIMIT = 10
    }
}

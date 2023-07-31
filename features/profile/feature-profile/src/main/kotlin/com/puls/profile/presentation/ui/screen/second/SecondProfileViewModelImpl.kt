package com.puls.profile.presentation.ui.screen.second

import androidx.lifecycle.viewModelScope
import com.puls.profile_domain.domain.model.response.User
import com.puls.profile_domain.domain.usecase.getuser.GetUserByIdUseCase
import com.puls.stateutil.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class SecondProfileViewModelImpl @Inject constructor(
    private val getUserByIdUseCase: GetUserByIdUseCase,
) : SecondProfileViewModel() {

    override val userDataFlow: MutableStateFlow<Result<User>> =
        MutableStateFlow(Result.Loading(false))

    override fun fetchContent(id: String) {
        viewModelScope.launch {
            userDataFlow.value = Result.Loading(true)
            userDataFlow.value = getUserByIdUseCase(id)
        }
    }
}

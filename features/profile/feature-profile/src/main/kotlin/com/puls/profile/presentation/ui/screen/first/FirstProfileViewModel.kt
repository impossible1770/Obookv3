package com.puls.profile.presentation.ui.screen.first

import com.puls.core.base.BaseViewModel
import com.puls.profile_domain.domain.model.response.User
import com.puls.stateutil.Result
import kotlinx.coroutines.flow.StateFlow

internal abstract class FirstProfileViewModel : BaseViewModel() {

    abstract val usersFlow: StateFlow<Result<List<User>>>

    abstract fun fetchContent()
}

package com.puls.home.presentation.ui.screen.home

import com.puls.core.base.BaseViewModel
import com.puls.home_domain.domain.model.response.User
import com.puls.stateutil.Result
import kotlinx.coroutines.flow.StateFlow

internal abstract class HomeViewModel : BaseViewModel() {

    abstract val usersFlow: StateFlow<Result<List<User>>>

    abstract fun fetchContent()
}

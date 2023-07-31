package com.puls.profile.presentation.ui.screen.second

import com.puls.core.base.BaseViewModel
import com.puls.profile_domain.domain.model.response.User
import com.puls.stateutil.Result
import kotlinx.coroutines.flow.StateFlow

internal abstract class SecondProfileViewModel : BaseViewModel() {

    abstract val userDataFlow: StateFlow<Result<User>>

    abstract fun fetchContent(id: String = MOCK_USER_ID)

    companion object {
        private const val MOCK_USER_ID = "8f26945c-3db9-51cd-bdee-8e9464795dc5"
    }
}

package com.puls.profile.presentation.ui.screen.first

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.puls.commondi.util.getDaggerViewModel
import com.puls.feature_profile.R
import com.puls.profile.di.component.ProfileComponentHolder
import com.puls.profile.presentation.ui.screen.second.SecondProfileScreen
import com.puls.profile_domain.domain.model.response.User
import com.puls.uicomponents.utils.LoadState
import javax.inject.Inject

internal class FirstProfileScreen : AndroidScreen() {

    @Composable
    override fun Content() {

        //Draw screen content
        Screen()
    }

    @Composable
    private fun Screen() {
        val firstProfileViewModel: FirstProfileViewModel = getDaggerViewModel(ProfileComponentHolder)
        val navigator = LocalNavigator.currentOrThrow
        val userList = firstProfileViewModel.usersFlow.collectAsState()

        //Fetch data
        LaunchedEffect(Unit) {
            firstProfileViewModel.fetchContent()
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            userList.value.LoadState(
                onRestartState = firstProfileViewModel::fetchContent,
                successContent = { data ->
                    ScreenContent(
                        usersList = data,
                        onClickNext = {
                              navigator.push(SecondProfileScreen())
                        }
                    )
                }
            )
        }
    }

    @Composable
    private fun ScreenContent(
        usersList: List<User>,
        onClickNext: () -> Unit
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Header()
            ActionButton(
                modifier = Modifier
                    .padding(top = 20.dp),
                onClickNext = onClickNext
            )
            UsersList(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 20.dp),
                usersList = usersList
            )
        }
    }

    @Composable
    private fun Header(
        modifier: Modifier = Modifier
    ) {
        Text(
            modifier = Modifier
                .then(modifier),
            text = stringResource(id = R.string.fragment_profile_title)
        )
    }

    @Composable
    private fun UsersList(
        modifier: Modifier = Modifier,
        usersList: List<User>
    ) {
        LazyColumn(
            modifier = Modifier
                .then(modifier),
            content = {
                items(
                    items = usersList,
                    key = { item -> item.id }
                ) { data ->
                    UserItem(
                        userName = data.fullName,
                        address = data.address
                    )
                }
            },
            verticalArrangement = Arrangement.spacedBy(24.dp)
        )
    }

    @Composable
    private fun UserItem(
        modifier: Modifier = Modifier,
        userName: String,
        address: String
    ) {
        Column(
            modifier = Modifier
                .then(modifier)
        ) {
            Text(text = stringResource(id = R.string.user_name_template, userName))
            Text(
                modifier = Modifier
                    .padding(top = 10.dp),
                text = stringResource(id = R.string.user_address_template, address)
            )
        }
    }

    @Composable
    private fun ActionButton(
        modifier: Modifier = Modifier,
        onClickNext: () -> Unit
    ) {
        Row(
            modifier = Modifier
                .then(modifier)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = onClickNext
            ) {
                Text(text = stringResource(id = R.string.go_to_profile_second_fragment))
            }
        }
    }
}
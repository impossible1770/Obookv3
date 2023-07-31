package com.icompany.home.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.icompany.home.R
import com.icompany.home.presentation.ui.screen.home.HomeScreen

class ClientsTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(R.string.menu_clients)
            val icon = painterResource(id = R.drawable.menu_clients)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(HomeScreen())
    }
}
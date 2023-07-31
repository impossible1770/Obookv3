package com.puls.profile.presentation.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import com.puls.feature_profile.R
import com.puls.profile.presentation.ui.screen.first.FirstProfileScreen

class ProfileTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(R.string.profile)
            val icon = rememberVectorPainter(Icons.Default.Person)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    override fun Content() {
        Navigator(FirstProfileScreen()) { navigator ->
            SlideTransition(navigator) { screen ->
                screen.Content()
            }
        }
    }
}
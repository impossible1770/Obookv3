package com.icompany.obook.presentation.ui.activity

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.icompany.obook.R
import com.icompany.obook.di.component.main.AppComponentHolder
import com.icompany.obook.utils.TabNavigationItem
import com.puls.core.base.action.ActivityActions
import com.puls.home.presentation.ui.screen.HomeTab
import com.puls.profile.presentation.ui.screen.ProfileTab
import com.puls.uicomponents.compose.theme.CustomTheme
import com.puls.uicomponents.compose.theme.DefaultTheme

internal class MainActivity : ComponentActivity(), ActivityActions {

    override fun onCreate(savedInstanceState: Bundle?) {
        AppComponentHolder.getInternal().inject(this)
        super.onCreate(savedInstanceState)

        setContent {
            val homeTab = HomeTab()
            val profileTab = ProfileTab()

            TabNavigator(homeTab) {
                DefaultTheme {
                    Scaffold(
                        content = {
                            CurrentTab()
                        },
                        bottomBar = {
                            NavBar(homeTab, profileTab)
                        }
                    )
                }
            }
        }
    }


    override fun getTheme(): Resources.Theme {
        val theme = super.getTheme()
        theme.applyStyle(R.style.Theme_ComposeMultiModuleTemplate, true)
        return theme
    }

    @Composable
    private fun NavBar(vararg tabs: Tab) {
        BottomNavigation(
            backgroundColor = CustomTheme.colors.dark_900_bg
        ) {
            tabs.forEach { tab ->
                TabNavigationItem(tab)
            }
        }
    }

}
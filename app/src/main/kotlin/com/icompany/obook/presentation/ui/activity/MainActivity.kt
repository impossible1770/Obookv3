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
import com.icompany.core.base.action.ActivityActions
import com.icompany.profile.presentation.ui.screen.ProductsTab
import com.icompany.uicomponents.compose.theme.CustomTheme
import com.icompany.uicomponents.compose.theme.DefaultTheme

internal class MainActivity : ComponentActivity(), ActivityActions {

    override fun onCreate(savedInstanceState: Bundle?) {
        AppComponentHolder.getInternal().inject(this)
        super.onCreate(savedInstanceState)

        setContent {
            val clientsTab = ClientsTab()
            val profileTab = ProductsTab()

            TabNavigator(clientsTab) {
                DefaultTheme {
                    Scaffold(
                        content = {
                            CurrentTab()
                        },
                        bottomBar = {
                            NavBar(*getTabs())
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

    private fun getTabs(): Array<Tab> {
        return arrayOf( ClientsTab(), ProductsTab())
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
@file:OptIn(ExperimentalResourceApi::class)

package codes.hipporasy.sleepsounds

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import codes.hipporasy.sleepsounds.presentation.MainRoute
import codes.hipporasy.sleepsounds.presentation.screens.DiscoverScreen
import codes.hipporasy.sleepsounds.presentation.theme.SleepTheme
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.koin.core.context.startKoin

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val mainRoutes = listOf(
        MainRoute.Discover,
        MainRoute.Composer,
        MainRoute.Profile
    )
    val selectedRoute = remember { mutableStateOf(mainRoutes.first()) }
    SleepTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            selectedRoute.value.toString(),
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                )
            },
            bottomBar = {
                NavigationBar {
                    mainRoutes.forEach { route ->
                        NavigationBarItem(
                            modifier = Modifier.padding(horizontal = 24.dp),
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = contentColorFor(MaterialTheme.colorScheme.onSurfaceVariant),
                                selectedTextColor = contentColorFor(MaterialTheme.colorScheme.onSurfaceVariant),
                                unselectedIconColor = contentColorFor(MaterialTheme.colorScheme.primary),
                                unselectedTextColor = contentColorFor(MaterialTheme.colorScheme.primary),
                                indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                                    LocalAbsoluteTonalElevation.current
                                )
                            ),
                            alwaysShowLabel = false,
                            icon = {
                                Icon(
                                    painter = painterResource("ic_${route.name.lowercase()}.xml"),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                            },
                            label = {
                                Text(route.toString())
                            },
                            selected = selectedRoute.value == route,
                            onClick = { selectedRoute.value = route },
                        )
                    }
                }
            }
        ) { paddingValues ->
            when (selectedRoute.value) {
                MainRoute.Discover -> DiscoverScreen(paddingValues)
                MainRoute.Composer -> Text(
                    modifier = Modifier.padding(paddingValues),
                    text = "Hello, world!",
                )
                MainRoute.Profile -> Text(
                    modifier = Modifier.padding(paddingValues),
                    text = "Hello, world!",
                )
            }

        }

    }
}

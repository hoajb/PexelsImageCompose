package vn.hoanguyen.android.pexelsimage.app.presentation.widgets

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarItem(val title: String, val icon: ImageVector)

private val items: List<BottomBarItem> = listOf(
    BottomBarItem(
        title = "Home", icon = Icons.Filled.Home
    ),
    BottomBarItem(
        title = "Search", icon = Icons.Filled.Search
    ),
    BottomBarItem(
        title = "Notification", icon = Icons.Filled.Notifications
    ),
    BottomBarItem(
        title = "Profile", icon = Icons.Filled.AccountCircle
    )
)

@Composable
fun BottomBar(
    onMenuItemSelected: (Int) -> Unit,
    onActionClick: () -> Unit,
    selectedPos: Int,
) {
    BottomAppBar(
        actions = {
            items.forEachIndexed { index, item ->
                val isSelected = selectedPos == index
                val scale by animateFloatAsState(
                    if (isSelected) 1.5f else 1f,
                    animationSpec = tween(durationMillis = 100), label = ""
                )

                IconButton(
                    onClick = {
                        onMenuItemSelected(index)
                    },
                    modifier = Modifier.scale(scale)
                ) {
                    Icon(
                        item.icon,
                        contentDescription = item.title,
                        tint = if (isSelected) Color.Black else Color.Gray
                    )
                }
            }
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* do something */ },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Add, "Localized description")
            }
        }
    )
}

@Composable
fun NavigationBar() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Songs", "Artists", "Playlists")

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}
package vn.hoanguyen.android.pexelsimage.app.presentation.components.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vn.hoanguyen.android.pexelsimage.app.presentation.components.list.HorizontalPhotoTitleData
import vn.hoanguyen.android.pexelsimage.app.presentation.components.list.HorizontalPhotoTitleList

@Composable
fun BrowseCategory() {
    HorizontalPhotoTitleList(
        modifier = Modifier
            .fillMaxWidth(),
        items = listOf(
            HorizontalPhotoTitleData(
                photoUrl = "https://images.pexels.com/photos/18357552/pexels-photo-18357552.jpeg?auto=compress&cs=tinysrgb&h=350",
                title = "Switzerland",
            ),
            HorizontalPhotoTitleData(
                photoUrl = "https://images.pexels.com/photos/18357552/pexels-photo-18357552.jpeg?auto=compress&cs=tinysrgb&h=350",
                title = "Gradient",
            ),
            HorizontalPhotoTitleData(
                photoUrl = "https://images.pexels.com/photos/18357552/pexels-photo-18357552.jpeg?auto=compress&cs=tinysrgb&h=350",
                title = "Street Lights",
            ),
            HorizontalPhotoTitleData(
                photoUrl = "https://images.pexels.com/photos/18357552/pexels-photo-18357552.jpeg?auto=compress&cs=tinysrgb&h=350",
                title = "Time",
            ),
            HorizontalPhotoTitleData(
                photoUrl = "https://images.pexels.com/photos/18357552/pexels-photo-18357552.jpeg?auto=compress&cs=tinysrgb&h=350",
                title = "Team",
            ),
            HorizontalPhotoTitleData(
                photoUrl = "https://images.pexels.com/photos/18357552/pexels-photo-18357552.jpeg?auto=compress&cs=tinysrgb&h=350",
                title = "Data",
            ),
            HorizontalPhotoTitleData(
                photoUrl = "https://images.pexels.com/photos/18357552/pexels-photo-18357552.jpeg?auto=compress&cs=tinysrgb&h=350",
                title = "Sleep",
            )
        )
    )
}
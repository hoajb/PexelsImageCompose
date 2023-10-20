package vn.hoanguyen.android.pexelsimage.app.presentation.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import vn.hoanguyen.android.pexelsimage.app.presentation.widgets.PexelsPhotoListPaging

@Composable
fun HomePage() {
    PexelsPhotoListPaging()
}


@Composable
fun PlaceHolderPage(
    text: String
) {
    Box( modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(text = text)
    }
}
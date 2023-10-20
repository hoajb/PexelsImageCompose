package vn.hoanguyen.android.pexelsimage.app.presentation.components.list

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import vn.hoanguyen.android.pexelsimage.app.R

@Composable
fun HorizontalPhotoTitleList(
    modifier: Modifier,
    photoSize: Int = 150,
    items: List<HorizontalPhotoTitleData>
) {
    LazyRow(
        modifier = modifier
    ) {
        items(
            count = items.size,
            itemContent = { index ->
                RowItem(
                    item = items[index],
                    photoSize = photoSize
                )
            }
        )
    }
}

@Composable
private fun RowItem(
    item: HorizontalPhotoTitleData,
    photoSize: Int,
) {
    Column(
        modifier = Modifier
            .padding(end = 10.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(item.photoUrl)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(R.string.description),
            modifier = Modifier
                .height(photoSize.dp)
                .width(photoSize.dp)
                .clip(MaterialTheme.shapes.medium),
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = item.title,
            maxLines = 1,
            modifier = Modifier
                .width(photoSize.dp),
            textAlign = TextAlign.Center
        )

    }
}

data class HorizontalPhotoTitleData(val photoUrl: String, val title: String)
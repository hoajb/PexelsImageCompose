package vn.hoanguyen.android.pexelsimage.app.presentation.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import vn.hoanguyen.android.pexelsimage.app.utils.StringUtils

@Composable
fun AsyncAvatar(
    url: String,
    fullName: String
) {
    SubcomposeAsyncImage(
        model = url,
        contentDescription = "contentDescription",
        contentScale = ContentScale.Crop,
        modifier = Modifier.clip(CircleShape)
    ) {
        val state = painter.state
        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {

            //text with a background circle
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .drawBehind {
                        drawCircle(
                            color = Color.LightGray,
                            radius = this.size.maxDimension
                        )
                    },
                text = StringUtils.getInitials(fullName),
                style = TextStyle(color = Color.White, fontSize = 18.sp)
            )
        } else {
            SubcomposeAsyncImageContent()
        }
    }
}


package vn.hoanguyen.android.pexelsimage.app.presentation.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import vn.hoanguyen.android.pexelsimage.app.R
import vn.hoanguyen.android.pexelsimage.app.domain.PexelsPhoto

@Composable
fun PhotoItem(photo: PexelsPhoto) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncAvatar(url = "", fullName = photo.photographer)
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                modifier = Modifier.weight(1f),
                text = photo.photographer,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )

            OutlinedButton(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(30),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Gray)
            ) {
                Text(text = "Follow")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        ImageLoader(
            photoUrl = photo.src.large2x,
            ratio = photo.width.toFloat() / photo.height
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ImageLoader(
    photoUrl: String,
    ratio: Float,
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(ratio)
    ) {
        if (constraints.maxWidth > 0) {
            // This is your AsyncImage component
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(photoUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(R.string.description),
            )
        } else {
            // Placeholder with gray background
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
            ) {
                // You can add a loading indicator or any other content here
            }
        }
    }
}
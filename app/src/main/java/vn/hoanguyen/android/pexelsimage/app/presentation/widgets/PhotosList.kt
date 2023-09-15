package vn.hoanguyen.android.pexelsimage.app.presentation.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import org.koin.androidx.compose.koinViewModel
import vn.hoanguyen.android.pexelsimage.app.R
import vn.hoanguyen.android.pexelsimage.app.core.presentation.UIState
import vn.hoanguyen.android.pexelsimage.app.domain.PexelsPhoto
import vn.hoanguyen.android.pexelsimage.app.presentation.viewmodels.ViewModelImagesList

@Composable
fun PexelsPhotoList(
    viewModel: ViewModelImagesList = koinViewModel(),
    modifier: Modifier = Modifier
) {
    val photosState: UIState<List<PexelsPhoto>> by remember { viewModel.photos }

    when (photosState) {
        is UIState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is UIState.Success -> {
            val photos = (photosState as UIState.Success<List<PexelsPhoto>>).data
            LazyColumn(
                modifier = modifier.fillMaxSize(),
            ) {
                items(
                    count = photos.size,
                    itemContent = { index ->
                        PhotoItem(photos[index])
                    }
                )
            }
        }

        is UIState.Error -> {
            val error = (photosState as UIState.Error).message
            Text(
                text = "Error: ${error}",
                color = Color.Red,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun PhotoItem(photo: PexelsPhoto) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Photographer: ${photo.photographer}",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(photo.src.medium)
                .crossfade(true)
                .build(),
//            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = stringResource(R.string.description),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PexelsPhotoListPreview() {
//    val samplePhotoList = listOf(
//        PexelsPhoto(
//            id = 1,
//            photographer = "Photographer 1",
//            src = PexelsPhotoSrc(
//                original = "https://images.pexels.com/photos/15286/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
//                large = "https://images.pexels.com/photos/15286/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
//                medium = "https://images.pexels.com/photos/15286/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
//                small = "https://images.pexels.com/photos/15286/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
//            )
//        ),
//        // Add more sample photos as needed
//    )
//
//    PexelsImageAppTheme {
//        PexelsPhotoList(samplePhotoList)
//    }
//}
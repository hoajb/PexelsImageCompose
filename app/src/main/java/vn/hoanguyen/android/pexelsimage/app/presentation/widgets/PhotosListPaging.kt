package vn.hoanguyen.android.pexelsimage.app.presentation.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import org.koin.androidx.compose.koinViewModel
import vn.hoanguyen.android.pexelsimage.app.presentation.viewmodels.ViewModelImagesListPaging

@Composable
fun PexelsPhotoListPaging(
    modifier: Modifier = Modifier,
    viewModel: ViewModelImagesListPaging = koinViewModel()
) {
    val photos = viewModel.fetchPexelsPhotos().collectAsLazyPagingItems()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        //FIRST LOAD
        when (val state = photos.loadState.refresh) {
            is LoadState.Error -> {
                item {
                    ErrorText(errorMessage = state.error.message)
                }
            }

            is LoadState.Loading -> { // Loading UI
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(8.dp),
                            text = "Refresh Loading"
                        )

                        CircularProgressIndicator(color = Color.Black)
                    }
                }
            }

            else -> {}
        }
        // Loaded Items
        items(
            count = photos.itemCount,
            itemContent = { index ->
                photos[index]?.let { PhotoItem(it) }
            }
        )

        //Appending
        when (val state = photos.loadState.append) { // Pagination
            is LoadState.Error -> {
                item {
                    ErrorText(errorMessage = state.error.message)
                }
            }

            is LoadState.Loading -> { // Pagination Loading UI
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(text = "Pagination Loading")

                        CircularProgressIndicator(color = Color.Black)
                    }
                }
            }

            else -> {}
        }
    }
}
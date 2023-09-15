package vn.hoanguyen.android.pexelsimage.app.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vn.hoanguyen.android.pexelsimage.app.core.ResultCall
import vn.hoanguyen.android.pexelsimage.app.core.presentation.UIState
import vn.hoanguyen.android.pexelsimage.app.domain.PexelsPhoto
import vn.hoanguyen.android.pexelsimage.app.domain.UseCaseFetchPexelsPhotosWithQuery

class ViewModelImagesList(
    private val useCaseFetchPexelsPhotosWithQuery: UseCaseFetchPexelsPhotosWithQuery
) : ViewModel() {
    private val photosState = mutableStateOf<UIState<List<PexelsPhoto>>>(UIState.Loading)
    val photos: State<UIState<List<PexelsPhoto>>> = photosState

    init {
        fetchPexelsPhotos()
    }

    private fun fetchPexelsPhotos() {
        viewModelScope.launch {
            try {
                val photosResult =
                    useCaseFetchPexelsPhotosWithQuery.execute("")
                when (photosResult) {
                    is ResultCall.Success -> {
                        photosState.value = UIState.Success(photosResult.data!!)
                    }

                    is ResultCall.Error -> {
                        photosState.value = UIState.Error(photosResult.message!!)
                    }
                }

            } catch (e: Exception) {
                photosState.value = UIState.Error(e.message.orEmpty())
            }
        }
    }
}
package vn.hoanguyen.android.pexelsimage.app.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import vn.hoanguyen.android.pexelsimage.app.core.ResultCall
import vn.hoanguyen.android.pexelsimage.app.core.constants.ImagesListConstant.PER_PAGE
import vn.hoanguyen.android.pexelsimage.app.core.presentation.UIState
import vn.hoanguyen.android.pexelsimage.app.domain.PexelsPhoto
import vn.hoanguyen.android.pexelsimage.app.domain.UseCaseFetchPexelsPhotosWithQuery
import vn.hoanguyen.android.pexelsimage.app.domain.UseCaseFetchPexelsPhotosWithQueryPaging

class ViewModelImagesListPaging(
    private val useCaseFetchPexelsPhotosWithQueryPaging: UseCaseFetchPexelsPhotosWithQueryPaging
) : ViewModel() {
    val itemsPerPage: Int = PER_PAGE
    fun fetchPexelsPhotos(query: String = ""): Flow<PagingData<PexelsPhoto>> =
        useCaseFetchPexelsPhotosWithQueryPaging.execute(query).cachedIn(viewModelScope)
}
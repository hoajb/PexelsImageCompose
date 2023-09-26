package vn.hoanguyen.android.pexelsimage.app.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class UseCaseFetchPexelsPhotosWithQueryPaging(
    private val repository: PhotosPagingRepository
) {
     fun execute(query: String): Flow<PagingData<PexelsPhoto>> =
        repository.fetchPexelsPhotos(query.ifEmpty { "nature" })
}
package vn.hoanguyen.android.pexelsimage.app.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface PhotosPagingRepository {
    fun fetchPexelsPhotos(query: String): Flow<PagingData<PexelsPhoto>>
}
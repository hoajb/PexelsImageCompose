package vn.hoanguyen.android.pexelsimage.app.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.inject
import vn.hoanguyen.android.pexelsimage.app.core.ResultCall
import vn.hoanguyen.android.pexelsimage.app.core.error.FormattedNetworkClientException

class UseCaseFetchPexelsPhotosWithQueryPaging(
    private val repository: PhotosPagingRepository
) {
     fun execute(query: String): Flow<PagingData<PexelsPhoto>> =
        repository.fetchPexelsPhotos(query.ifEmpty { "nature" })
}
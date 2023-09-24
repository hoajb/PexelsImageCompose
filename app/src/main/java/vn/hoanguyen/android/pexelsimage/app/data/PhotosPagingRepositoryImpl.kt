package vn.hoanguyen.android.pexelsimage.app.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import vn.hoanguyen.android.pexelsimage.app.core.constants.ImagesListConstant.PER_PAGE
import vn.hoanguyen.android.pexelsimage.app.domain.PhotosPagingRepository

class PhotosPagingRepositoryImpl(
    private val service: PexelsService,
) : PhotosPagingRepository {

    override fun fetchPexelsPhotos(query: String) = Pager(
        config = PagingConfig(
            pageSize = PER_PAGE,
        ),
        pagingSourceFactory = {
            PhotosPagingDataSource(query = query, service = service)
        }
    ).flow
}
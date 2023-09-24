package vn.hoanguyen.android.pexelsimage.app.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import vn.hoanguyen.android.pexelsimage.app.domain.PexelsPhoto

class PhotosPagingDataSource(
    private val query: String,
    private val service: PexelsService,
) : PagingSource<Int, PexelsPhoto>() {
    override fun getRefreshKey(state: PagingState<Int, PexelsPhoto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PexelsPhoto> {
        return try {
            val page = params.key ?: 1
            val response = service.fetchPexelsPhotos(
                query = query,
                page = page
            )

            LoadResult.Page(
                data = response.photos.toEntityList(),
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.photos.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
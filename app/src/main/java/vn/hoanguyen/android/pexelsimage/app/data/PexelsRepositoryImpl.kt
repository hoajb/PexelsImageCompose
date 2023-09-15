package vn.hoanguyen.android.pexelsimage.app.data

import vn.hoanguyen.android.pexelsimage.app.domain.PexelsPhoto
import vn.hoanguyen.android.pexelsimage.app.domain.PexelsRepository

class PexelsRepositoryImpl(
    private val service: PexelsService
) : PexelsRepository {
    override suspend fun fetchPexelsPhotos(query: String): List<PexelsPhoto> {
        return service.fetchPexelsPhotos(query).photos.toEntityList()
    }
}
package vn.hoanguyen.android.pexelsimage.app.domain

interface PexelsRepository {
    suspend fun fetchPexelsPhotos(query: String): List<PexelsPhoto>
}
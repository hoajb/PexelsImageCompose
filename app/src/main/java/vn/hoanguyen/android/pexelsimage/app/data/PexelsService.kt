package vn.hoanguyen.android.pexelsimage.app.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import vn.hoanguyen.android.pexelsimage.app.core.constants.ImagesListConstant.PER_PAGE
import vn.hoanguyen.android.pexelsimage.app.data.response.ListPhotosResponse

class PexelsService(
    private val httpClient: HttpClient,
    private val routes: Routes,
) {
    suspend fun fetchPexelsPhotos(query: String, page: Int = 1): ListPhotosResponse {
        return httpClient.get(routes.SEARCH) {
            parameter("query", query)
            parameter("page", page)
            parameter("per_page", PER_PAGE)
        }.body() as ListPhotosResponse
    }
}
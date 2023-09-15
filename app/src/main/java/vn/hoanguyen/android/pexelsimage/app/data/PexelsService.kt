package vn.hoanguyen.android.pexelsimage.app.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.path
import vn.hoanguyen.android.pexelsimage.app.data.response.PexelsResponse

class PexelsService(
    private val httpClient: HttpClient,
    private val routes: Routes,
) {
    suspend fun fetchPexelsPhotos(query: String, page: Int = 1): PexelsResponse {
        return httpClient.get(routes.SEARCH) {
            parameter("query", query)
            parameter("page", page)
            parameter("per_page", 10)
        }.body() as PexelsResponse
    }
}
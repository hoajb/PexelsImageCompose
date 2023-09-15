package vn.hoanguyen.android.pexelsimage.app.domain

import vn.hoanguyen.android.pexelsimage.app.core.ResultCall
import vn.hoanguyen.android.pexelsimage.app.core.error.FormattedNetworkClientException

class UseCaseFetchPexelsPhotosWithQuery(private val repository: PexelsRepository) {
    suspend fun execute(query: String): ResultCall<List<PexelsPhoto>> {
        return try {
            ResultCall.Success(repository.fetchPexelsPhotos(query.ifEmpty { "nature" }))
        } catch (exception: FormattedNetworkClientException) {
            ResultCall.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            ResultCall.Error("Server or network error")
        }
    }
}
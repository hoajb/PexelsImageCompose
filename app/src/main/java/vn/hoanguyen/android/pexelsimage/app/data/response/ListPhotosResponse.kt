package vn.hoanguyen.android.pexelsimage.app.data.response

import kotlinx.serialization.Serializable
import vn.hoanguyen.android.pexelsimage.app.data.PexelsPhotoDto

@Serializable
data class ListPhotosResponse(
    val page: Int?,
    val per_page: Int?,
    val total_results: Int?,
//    val next_page: String?,
//    val prev_page: String?,
    val photos: List<PexelsPhotoDto>
) {
}
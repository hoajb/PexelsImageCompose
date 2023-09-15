package vn.hoanguyen.android.pexelsimage.app.data.response

import kotlinx.serialization.Serializable
import vn.hoanguyen.android.pexelsimage.app.data.PexelsPhotoDto

@Serializable
data class PexelsResponse(val photos: List<PexelsPhotoDto>)
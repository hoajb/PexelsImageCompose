package vn.hoanguyen.android.pexelsimage.app.domain

data class PexelsPhoto(
    val id: Long,
    val photographer: String,
    val src: PexelsPhotoSrc
)

data class PexelsPhotoSrc(
    val original: String,
    val large: String,
    val medium: String,
    val small: String
)
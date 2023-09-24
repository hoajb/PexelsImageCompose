package vn.hoanguyen.android.pexelsimage.app.domain

data class PexelsPhoto(
    val id: Long,
    val width: Int,
    val height: Int,
    val photographer: String,
    val src: PexelsPhotoSrc
)

data class PexelsPhotoSrc(
    val original: String,
    val large2x: String,
    val large: String,
    val medium: String,
    val small: String,
    val portrait: String,
    val landscape: String,
    val tiny: String,
)


//https://www.pexels.com/api/documentation/#photos-search
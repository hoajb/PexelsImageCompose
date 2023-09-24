package vn.hoanguyen.android.pexelsimage.app.data

import kotlinx.serialization.Serializable
import vn.hoanguyen.android.pexelsimage.app.domain.PexelsPhoto
import vn.hoanguyen.android.pexelsimage.app.domain.PexelsPhotoSrc

@Serializable
data class PexelsPhotoDto(
    val id: Long,
    val width: Int,
    val height: Int,
    val photographer: String,
    val src: PexelsPhotoSrcDto
)

@Serializable
data class PexelsPhotoSrcDto(
    val original: String,
    val large2x: String,
    val large: String,
    val medium: String,
    val small: String,
    val portrait: String,
    val landscape: String,
    val tiny: String,
)

//Mapping
fun PexelsPhotoDto.toEntity() = PexelsPhoto(
    id = this.id,
    width = this.width,
    height = this.height,
    photographer = this.photographer,
    src = this.src.toEntity(),
)

fun PexelsPhotoSrcDto.toEntity() = PexelsPhotoSrc(
    original = this.original,
    large2x = this.large2x,
    large = this.large,
    medium = this.medium,
    small = this.small,
    portrait = this.portrait,
    landscape = this.landscape,
    tiny = this.tiny,
)

fun List<PexelsPhotoDto>.toEntityList(): List<PexelsPhoto> {
    return this.map { it.toEntity() }
}

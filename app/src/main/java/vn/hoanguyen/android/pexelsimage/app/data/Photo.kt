package vn.hoanguyen.android.pexelsimage.app.data

import kotlinx.serialization.Serializable
import vn.hoanguyen.android.pexelsimage.app.domain.PexelsPhoto
import vn.hoanguyen.android.pexelsimage.app.domain.PexelsPhotoSrc

@Serializable
data class PexelsPhotoDto(
    val id: Long,
    val photographer: String,
    val src: PexelsPhotoSrcDto
)

@Serializable
data class PexelsPhotoSrcDto(
    val original: String,
    val large: String,
    val medium: String,
    val small: String
)

//Mapping
fun PexelsPhotoDto.toEntity() = PexelsPhoto(
    id = this.id,
    photographer = this.photographer,
    src = this.src.toEntity(),
)

fun PexelsPhotoSrcDto.toEntity() = PexelsPhotoSrc(
    original = this.original,
    large = this.large,
    medium = this.medium,
    small = this.small,
)

fun List<PexelsPhotoDto>.toEntityList(): List<PexelsPhoto> {
    return this.map { it.toEntity() }
}

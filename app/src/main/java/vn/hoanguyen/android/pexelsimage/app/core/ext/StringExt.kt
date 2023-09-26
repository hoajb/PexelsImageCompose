package vn.hoanguyen.android.pexelsimage.app.core.ext

/**
 * Created by Hoa Nguyen on Apr 15 2023.
 */
object Strings {
    const val EMPTY = ""
    const val SPACE = " "
}

fun String?.ifNullOrEmpty(defaultValue: () -> String): String =
    if (isNullOrEmpty()) defaultValue() else this

fun String?.capitalizeSentences(): String {
    return if (isNullOrEmpty()) Strings.EMPTY
    else {
        return lowercase().split(Strings.SPACE.toRegex())
            .joinToString(separator = Strings.SPACE) { string ->
                string.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
            }
    }
}

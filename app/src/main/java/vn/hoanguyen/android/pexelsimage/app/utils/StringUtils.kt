package vn.hoanguyen.android.pexelsimage.app.utils

import java.util.Locale

object StringUtils {
    fun getInitials(fullName: String): String {
        val nameParts = fullName.split(" ")
        if (nameParts.size == 1) {
            // If only the first name is provided, return the first two characters.
            return nameParts[0].take(2).uppercase(Locale.getDefault())
        }

        var initials = ""
        for (part in nameParts.take(2)) {
            if (part.isNotEmpty()) {
                initials += part[0]
            }
        }
        return initials.uppercase(Locale.getDefault())
    }
}
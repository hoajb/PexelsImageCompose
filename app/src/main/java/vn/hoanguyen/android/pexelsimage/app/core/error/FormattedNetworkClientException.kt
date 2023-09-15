package vn.hoanguyen.android.pexelsimage.app.core.error

class FormattedNetworkClientException(
    val formattedErrorMessage: String
) : Exception(formattedErrorMessage) {
}
package vn.hoanguyen.android.pexelsimage.app.core

sealed class ResultCall<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T): ResultCall<T>(data)
    class Error<T>(message: String): ResultCall<T>(message = message)
}
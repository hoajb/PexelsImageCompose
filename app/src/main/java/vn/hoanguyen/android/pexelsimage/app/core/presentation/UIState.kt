package vn.hoanguyen.android.pexelsimage.app.core.presentation

sealed class UIState<out T> {
    data class Success<out T>(val data: T) : UIState<T>()
    data class Error(val message: String) : UIState<Nothing>()
    object Loading : UIState<Nothing>()
}
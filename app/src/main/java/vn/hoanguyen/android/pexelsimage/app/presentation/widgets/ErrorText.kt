package vn.hoanguyen.android.pexelsimage.app.presentation.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import vn.hoanguyen.android.pexelsimage.app.core.ext.ifNullOrEmpty

@Composable
fun ErrorText(errorMessage: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = errorMessage.ifNullOrEmpty { "Unknown Error" },
            color = Color.Red,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}
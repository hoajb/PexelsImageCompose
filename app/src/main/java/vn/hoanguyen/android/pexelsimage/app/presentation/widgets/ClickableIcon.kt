package vn.hoanguyen.android.pexelsimage.app.presentation.widgets

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ClickableIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    imageVectorChecked: ImageVector,
    contentDescription: String? = null,
    onClick: () -> Unit,
    isChecked: Boolean
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(
            imageVector = if (isChecked) imageVectorChecked else imageVector,
            contentDescription = contentDescription,
        )
    }
}
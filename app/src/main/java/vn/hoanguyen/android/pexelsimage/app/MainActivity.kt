package vn.hoanguyen.android.pexelsimage.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import vn.hoanguyen.android.pexelsimage.app.core.ui.theme.AppTheme
import vn.hoanguyen.android.pexelsimage.app.presentation.pages.MainPage

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                MainPage()
            }
        }
    }
}
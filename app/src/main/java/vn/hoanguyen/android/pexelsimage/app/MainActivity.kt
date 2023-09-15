package vn.hoanguyen.android.pexelsimage.app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vn.hoanguyen.android.pexelsimage.app.core.ui.theme.PexelsImageAppTheme
import vn.hoanguyen.android.pexelsimage.app.presentation.widgets.BottomBar
import vn.hoanguyen.android.pexelsimage.app.presentation.widgets.PexelsPhotoList

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var selectedPos by remember { mutableIntStateOf(0) }
            PexelsImageAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text("Top app bar")
                                }
                            )
                        },
                        bottomBar = {
                            BottomBar(
                                selectedPos = selectedPos,
                                onMenuItemSelected = { pos ->
                                    selectedPos = pos
                                    Toast.makeText(this, "id: $pos", Toast.LENGTH_SHORT).show()
                                },
                                onActionClick = {
                                    //Action Add
                                })

                        },
                    ) { innerPadding ->
                        Column(
                            modifier = Modifier
                                .padding(innerPadding),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                        ) {
                            PexelsPhotoList()
                        }
                    }

                }
            }
        }
    }
}
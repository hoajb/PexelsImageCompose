package vn.hoanguyen.android.pexelsimage.app.presentation.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vn.hoanguyen.android.pexelsimage.app.presentation.components.search.BrowseCategory
import vn.hoanguyen.android.pexelsimage.app.presentation.widgets.SearchBar

@Composable
@Preview()
fun SearchPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        //Search Box
        SearchBar()

        //Browse by Category
        Heading("Browse by Category")
        BrowseCategory()
        //Challenges

        // Popular Collections
    }
}

@Composable
private fun Heading(title: String) {
    Text(
        title,
        fontSize = 22.sp,
        modifier = Modifier.padding(vertical = 16.dp),
    )
}
package vn.hoanguyen.android.pexelsimage.app.presentation.pages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import vn.hoanguyen.android.pexelsimage.app.R
import vn.hoanguyen.android.pexelsimage.app.presentation.widgets.BottomBar
import vn.hoanguyen.android.pexelsimage.app.presentation.widgets.bottomBarItems

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainPage() {
    val pagerState = rememberPagerState()
    var selectedPosState by remember { mutableIntStateOf(0) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }
        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
            topBar = {
                TopAppBar(
                    title = {
                        Text(stringResource(id = R.string.app_name))
                    }
                )
            },
            bottomBar = {
                BottomBar(
                    selectedPos = selectedPosState,
                    onMenuItemSelected = { pos ->
                        scope.launch {
                            selectedPosState = pos
                            pagerState.animateScrollToPage(pos)
//                            snackbarHostState.showSnackbar("id: $pos")
                        }
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
                LaunchedEffect(pagerState) {
                    snapshotFlow { pagerState.currentPage }.collect { page ->
                        selectedPosState = page
                    }
                }
                HorizontalPager(
                    pageCount = bottomBarItems.size,
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) { page ->
                    when (page) {
                        0 -> {
//                            HomePage()
                            SearchPage()
                        }

                        1 -> {
//                            SearchPage()
//                            HomePage()
                            PlaceHolderPage(text = "SearchPage")
                        }

                        2 -> {
                            PlaceHolderPage(text = "Notification")
                        }

                        3 -> {
                            PlaceHolderPage(text = "User")
                        }
                    }
                }
            }
        }
    }
}
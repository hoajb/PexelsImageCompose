package vn.hoanguyen.android.pexelsimage.app.core.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import vn.hoanguyen.android.pexelsimage.app.data.networkModule
import vn.hoanguyen.android.pexelsimage.app.domain.domainModule
import vn.hoanguyen.android.pexelsimage.app.presentation.viewmodels.ViewModelImagesList
import vn.hoanguyen.android.pexelsimage.app.presentation.viewmodels.ViewModelImagesListPaging

val viewModelModule: Module = module {
    viewModel { ViewModelImagesList(get()) }
    viewModel { ViewModelImagesListPaging(get()) }
}
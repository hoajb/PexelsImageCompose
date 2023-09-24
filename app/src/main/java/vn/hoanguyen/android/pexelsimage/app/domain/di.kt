package vn.hoanguyen.android.pexelsimage.app.domain

import org.koin.core.module.Module
import org.koin.dsl.module
import vn.hoanguyen.android.pexelsimage.app.data.PexelsRepositoryImpl

val domainModule: Module = module {
    single { UseCaseFetchPexelsPhotosWithQuery(get()) }
    single { UseCaseFetchPexelsPhotosWithQueryPaging(get()) }
}
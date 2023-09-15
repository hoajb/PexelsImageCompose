package vn.hoanguyen.android.pexelsimage.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level
import vn.hoanguyen.android.pexelsimage.app.core.di.viewModelModule
import vn.hoanguyen.android.pexelsimage.app.data.networkModule
import vn.hoanguyen.android.pexelsimage.app.domain.domainModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
//            androidLogger(Level.DEBUG)
            modules(
                domainModule,
                networkModule,
                viewModelModule,
            ) // Add your Koin modules here
        }
    }
}
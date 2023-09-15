package vn.hoanguyen.android.pexelsimage.app.data

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import vn.hoanguyen.android.pexelsimage.app.BuildConfig
import vn.hoanguyen.android.pexelsimage.app.core.error.FormattedNetworkClientException

val networkModule: Module = module {
    single(named("baseURL")) { "https://api.pexels.com/v1" }
    single { Routes(get<String>(named("baseURL"))) }
    single(named("apiKey")) { BuildConfig.PEXELS_API_KEY }
    single { PexelsService(get(), get()) }
    single {
        HttpClient(Android) {
            install(Logging) {
//                logger = object : Logger {
//                    override fun log(message: String) {
//                        Napier.d("HTTP Client", null, message)
//                    }
//                }
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }

            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    encodeDefaults = false
                })
            }

            HttpResponseValidator {
                handleResponseExceptionWithRequest { exception, _ ->
                    throw FormattedNetworkClientException(
                        exception.localizedMessage ?: "Unknown Error"
                    )
                }
            }

            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                header(HttpHeaders.Authorization, get<String>(named("apiKey")))
            }
        }.also { Napier.base(DebugAntilog()) }
    }
}
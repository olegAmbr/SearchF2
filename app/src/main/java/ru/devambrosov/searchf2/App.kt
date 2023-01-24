package ru.devambrosov.searchf2

import android.app.Application
import android.icu.util.TimeUnit
import ru.devambrosov.searchf2.data.ApiConstants
import ru.devambrosov.searchf2.data.MainRepository
import ru.devambrosov.searchf2.data.TmdbApi
import ru.devambrosov.searchf2.domain.Interactor
import kotlin.time.DurationUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {
    lateinit var repo: MainRepository
    lateinit var interactor: Interactor
    lateinit var retrofitService: TmdbApi

    override fun onCreate() {
        super.onCreate()
        //Инициализируем экземпляр App, через который будем получать доступ к остальным переменным
        instance = this
        //Инициализируем репозиторий
        repo = MainRepository()
        //Создаем кастомный клиент
        val okHttpClient = OkHttpClient.Builder()
            //Настриваем таймауты для медленного интрнета
            .callTimeout(30, DurationUnit.SECONDS)
            .readTimeout(30, DurationUnit.SECONDS)
            //Добавляем логгер
            .addInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BASIC
                }
            })
            .build()
        //Создаем ретрофит
        val retrofit = Retrofit.Builder()
            //Указываем базовый URL из констант
            .baseUrl(ApiConstants.BASE_URL)
            //Добавляем конвертер
            .addConverterFactory(GsonConverterFactory.create())
            //Добавляем кастомный клиент
            .client(okHttpClient)
            .build()
        //Создаем сам сервис с методами для запросов
        retrofitService = retrofit.create(TmdbApi::class.java)
        //Инициализируем интерактор
        interactor = Interactor(repo, retrofitService)
    }

    companion object {
        //Здесь статически хранится ссылка на экземпляр App
        lateinit var instance: App
            //Приватный сеттер, чтобы нельзя было в эту переменную присвоить что-либо другое
            private set
    }


}
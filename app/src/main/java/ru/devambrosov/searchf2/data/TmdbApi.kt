package ru.devambrosov.searchf2.data

import android.telecom.Call
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.devambrosov.searchf2.data.Entity.TmdbResultsDto

interface TmdbApi {
    @GET("3/movie/popular")
    fun getFilms (
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ) : Call<TmdbResultsDto>
}

annotation class GET(val value: String)

annotation class Query(val value: String)

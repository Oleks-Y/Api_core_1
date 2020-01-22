package com.example.myapplication

import android.database.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query



private const val BASE_URL = "https://api.audd.io/"

data class Query(
    val line : String
)

data class Result(
    val song_id : String,
    val artist_id :String,
    val title : String,
    val title_with_featured : String,
    val full_title : String
)

interface Searching_Song_Servise {

    @GET("findLyrics/?")
    fun search(@Query("q") query: String): Observable<Result>
    /**
     * Companion object to create the GithubApiService
     */
    companion object Factory {
        fun create(): Searching_Song_Servise {
            val retrofit = Retrofit.Builder()

                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.audd.io/")
                .build()

            return retrofit.create(Searching_Song_Servise::class.java);
        }
    }
}
//val apiService = GithubApiService.create()
//apiService.search(/* search params go in here */)
fun Get_song( line : String): String {
    val apiService = Searching_Song_Servise.create()
    val info = apiService.search(line).toString()
    return info
}

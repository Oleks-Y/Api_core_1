package com.example.myapplication

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = "https://api.audd.io/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

private var q : String=""

fun set_first_API(a : String) {
    q = a
}


interface  MarsApiService{
    @GET("findLyrics/?")
    fun getProperties(@Query("q") query: String):
            Call<String>

}

object MarsApi{
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}

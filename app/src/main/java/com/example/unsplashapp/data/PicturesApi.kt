package com.example.unsplashapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface PicturesApi {
    @GET("search/photos")
    fun getPictures(
        @Query("page") page: Int,
        @Query("query") query: String,
        @Query("client_id") clientId: String,

        ): Call<MainObjectClass>

    @GET("search/photos")
    fun getPicId(
        @Query("page") page: Int,
        @Query("query") query: String,
        @Query("client_id") clientId: String,
        id: String?

    ): Call<ApiGood.Good>


}
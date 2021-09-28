package com.example.unsplashapp.data

import android.app.DownloadManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class ApiRepository: CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO

    private val picturesApi: PicturesApi = Retrofit.Builder()
        .baseUrl("https://api.unsplash.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PicturesApi::class.java)

    fun getData(query: String) = async {
        picturesApi.getPictures(page = 1, query = "", clientId = "DUBVa4jfDLSp5x-fltbelabCHZVE854DKQTyqlK6Pts")
    }
}
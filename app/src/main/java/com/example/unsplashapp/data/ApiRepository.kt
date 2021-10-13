package com.example.unsplashapp.data

import com.example.unsplashapp.app.SearchFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class ApiRepository : CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO

    private val picturesApi: PicturesApi = Retrofit.Builder()
        .baseUrl("https://api.unsplash.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PicturesApi::class.java)

    fun getData(id: String) = async {
        picturesApi.getPictures(
            page = 1,
            query = SearchFragment.just,
            clientId = "DUBVa4jfDLSp5x-fltbelabCHZVE854DKQTyqlK6Pts",
            id
        )
            .execute()
            .body()
            ?.results
    }


}
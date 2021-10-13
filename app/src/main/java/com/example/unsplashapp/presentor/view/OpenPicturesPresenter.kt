package com.example.unsplashapp.presentor.view

import com.example.unsplashapp.data.ApiRepository
import com.example.unsplashapp.data.Result
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class OpenPicturesPresenter(val view: OpenPictureContract.View) : OpenPictureContract.Presenter,
    CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val repository = ApiRepository()
    lateinit var result: Result


    override fun getPictures(id: String?) {
        GlobalScope.launch(Dispatchers.IO){
            result = repository.getDataPic(id).await()!!

            withContext(Dispatchers.Main){
                view.setData(result)
            }
        }

    }
}
package com.example.unsplashapp.presentor.view

import com.example.unsplashapp.data.ApiRepository
import com.example.unsplashapp.data.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

//class OpenPicturesPresenter(val view: OpenPictureContract.View) : OpenPictureContract.Presenter,
//    CoroutineScope {
//    override val coroutineContext: CoroutineContext = Dispatchers.Main
//
//    private val repository = ApiRepository()
//    lateinit var result: Result
//
//    override fun getPictures(id: Int) {
//        GlobalScope.launch(Dispatchers.IO) {
//            result = repository.getData()
//        }
//
//    }
//
//
//}
package com.example.unsplashapp.presentor.view

import com.example.unsplashapp.data.Result

interface OpenPictureContract {

    interface View {
        fun setData(result: Result)

    }

    interface Presenter {
        fun getPictures(id: Int)
    }

}
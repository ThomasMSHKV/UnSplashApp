package com.example.unsplashapp.presentor.view

import com.example.unsplashapp.data.Result

interface PicturesContract {

    interface View {
        fun setData(result: List<Result>)
        fun replaceData(result: List<Result>)

    }
}
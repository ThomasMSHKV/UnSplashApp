package com.example.unsplashapp.domain

import com.example.unsplashapp.data.Result

interface PicturesCallback {
    fun setList(list: List<Result>)
    fun onItemClick(result: Result)

}
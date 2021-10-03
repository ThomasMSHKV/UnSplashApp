package com.example.unsplashapp.domain

import com.example.unsplashapp.data.Result

interface PicturesCallback {
    fun onItemClick(result: Result)
}
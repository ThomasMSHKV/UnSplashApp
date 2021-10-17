package com.example.unsplashapp.presentor.view

import com.example.unsplashapp.data.Result

interface OrdersCallback {
    fun setList(list: List<Result>)
    fun openFragment(urls: String, number: Int)
}
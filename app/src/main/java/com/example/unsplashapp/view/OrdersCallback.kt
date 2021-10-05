package com.example.unsplashapp.view

import com.example.unsplashapp.data.Result

interface OrdersCallback {
    fun setList(list: List<Result>)
    fun openFragment(picture_id: String, number: Int)
}
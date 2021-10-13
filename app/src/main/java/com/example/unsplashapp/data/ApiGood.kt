package com.example.unsplashapp.data

import com.google.gson.annotations.SerializedName

interface ApiGood {
    data class Good(
        @SerializedName("data")
        var result: Result
    )
}
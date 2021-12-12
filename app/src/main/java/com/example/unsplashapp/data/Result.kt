package com.example.unsplashapp.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Result(
    val alt_description: String,
    val blur_hash: String,
    val categories:  @RawValue List<Any>,
    val color: String,
    val created_at: String,
    val current_user_collections: @RawValue List<Any>,
    val description: String,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val promoted_at: String,
    val sponsorship:  @RawValue  Any,
    val updated_at: String,
    val urls: @RawValue UrlsX,
    val width: Int
):Parcelable
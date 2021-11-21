package com.example.unsplashapp.data

import android.os.Parcel
import android.os.Parcelable

data class Result(
    val alt_description: String,
    val blur_hash: String,
    val categories: List<Any>,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: String,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val promoted_at: String,
    val sponsorship: Any,
    val updated_at: String,
    val urls: UrlsX,
    val width: Int
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readParcelable(UrlsX::class.java.classLoader)!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(alt_description)
        parcel.writeString(blur_hash)
        parcel.writeString(color)
        parcel.writeString(created_at)
        parcel.writeString(description)
        parcel.writeInt(height)
        parcel.writeString(id)
        parcel.writeByte(if (liked_by_user) 1 else 0)
        parcel.writeInt(likes)
        parcel.writeString(promoted_at)
        parcel.writeString(updated_at)
        parcel.writeInt(width)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Result> {
        override fun createFromParcel(parcel: Parcel): Result {
            return Result(parcel)
        }

        override fun newArray(size: Int): Array<Result?> {
            return arrayOfNulls(size)
        }
    }
}
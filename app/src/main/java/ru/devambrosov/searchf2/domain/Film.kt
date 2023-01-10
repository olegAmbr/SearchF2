package ru.devambrosov.searchf2.domain

import android.os.Parcel
import android.os.Parcelable

@Film.Parcelize
data class Film(
    val title: String?,
    val poster: Int,
    val description: String?,
    var rating: Float = 0f,
    var isInFavorites: Boolean = false
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    annotation class Parcelize

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(poster)
        parcel.writeString(description)
        parcel.writeFloat(rating)
        parcel.writeByte(if (isInFavorites) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Film> {
        override fun createFromParcel(parcel: Parcel): Film {
            return Film(parcel)
        }

        override fun newArray(size: Int): Array<Film?> {
            return arrayOfNulls(size)
        }
    }
}

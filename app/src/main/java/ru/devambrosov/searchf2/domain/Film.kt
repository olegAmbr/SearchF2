package ru.devambrosov.searchf2.domain

import android.os.Parcel
import android.os.Parcelable

@Parcelize
data class Film(
    val title: String?,
    val poster: String?, //У нас будет приходить ссылка на картинку, так что теперь это String
    val description: String?,
    var rating: Double = 0.0, //Приходит не целое число с API
    var isInFavorites: Boolean = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(poster)
        parcel.writeString(description)
        parcel.writeDouble(rating)
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

annotation class Parcelize

package com.example.finalkotlinv12021

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

data class Equipo(override var Tipo:String, override var Marca:String, override var Modelo:String, override var Precio: String):Machine(),
Parcelable {
    companion object{
        @JvmField val CREATOR: Parcelable.Creator<Equipo> = object : Parcelable.Creator<Equipo>{
            override fun newArray(size: Int): Array<Equipo?> = arrayOfNulls(size)

            @RequiresApi(Build.VERSION_CODES.Q)
            override fun createFromParcel(source: Parcel): Equipo = Equipo(source)
        }
    }
    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(source: Parcel) : this
        (source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!
    )


    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.let{
            dest.writeString(Tipo)
            dest.writeString(Marca)
            dest.writeString(Modelo)
            dest.writeString(Precio)
        }
    }

    override fun describeContents(): Int=0
}
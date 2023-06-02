package com.drug.application.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
 class Drug(var type: String,
            var name: String,
            var security: String,
            var storageLocation: String,
            var id: Int,
            var expiryDate: String,
            var red: Int,
            var removed:Int) : Parcelable{

    constructor(type: String,
                name: String,
                security: String,
                storageLocation: String,
                id: Int,
                expiryDate: String) : this(type,name,security,storageLocation,id,expiryDate,0,0) {

    }
}
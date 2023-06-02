package com.drug.application.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class CheckHistory(
    var storageLocation: String,
    var date: String,
    var performed: String,
    var signature: String,
    var drug: List<Drug>?
) : Parcelable {

    constructor(
         storageLocation: String,
         date: String,
    ) : this(storageLocation, date, "", "", null) {

    }

}
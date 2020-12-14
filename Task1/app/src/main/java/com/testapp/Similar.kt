package com.testapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Similar(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("image")
    val image: String
) {
}
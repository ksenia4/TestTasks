package com.testapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Rate(
    @Expose
    @SerializedName("score")
    val score: Double,
    @Expose
    @SerializedName("amount")
    val amount: Int){
}
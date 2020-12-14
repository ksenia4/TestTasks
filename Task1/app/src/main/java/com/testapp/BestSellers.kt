package com.testapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BestSellers(
    @Expose
    @SerializedName("id")
    val id: Integer,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("author")
    val author: String,
    @Expose
    @SerializedName("price")
    val price: Double,
    @Expose
    @SerializedName("image")
    val image: String,
    @Expose
    @SerializedName("rate")
    val rate: Rate
) {
}
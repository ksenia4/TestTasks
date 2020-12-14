package com.testapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface EbookApiInterface {

    @GET("carousel")
    fun getCarousel(): Call<List<Carousel>>

    @GET("best")
    fun getBestSellers(): Call<List<BestSellers>>

    @GET("similar")
    fun getSimilar(): Call<List<Similar>>
}
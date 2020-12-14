package com.testapp

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object EbookApiClient {
    var BASE_URL: String = "https://my-json-server.typicode.com/stellardiver/ebookdata/"
    val getClient: EbookApiInterface
        get() {

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val client = OkHttpClient.Builder().build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(EbookApiInterface::class.java)

        }
}
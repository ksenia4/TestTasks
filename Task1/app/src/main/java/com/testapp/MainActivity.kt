package com.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    var carouselList = ArrayList<Carousel>()
    var bestSellersList = ArrayList<BestSellers>()
    lateinit var carouselView: RecyclerView
    lateinit var bestSellersView: RecyclerView
    lateinit var adapter: CarouselAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carouselView = findViewById<RecyclerView>(R.id.carousel_view)
        carouselView.adapter = CarouselAdapter(carouselList, this)
        carouselView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        bestSellersView = findViewById<RecyclerView>(R.id.best_sellers_view)
        bestSellersView.adapter = BestSellersAdapter(bestSellersList, this)
        bestSellersView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        getData()

    }

    private fun getData() {
        val callCarousel: Call<List<Carousel>> = EbookApiClient.getClient.getCarousel()
        callCarousel.enqueue(object : Callback<List<Carousel>> {

            override fun onResponse(
                call: Call<List<Carousel>>?,
                response: Response<List<Carousel>>?
            ) {
                carouselList.addAll(response!!.body()!!)
                carouselView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Carousel>>?, t: Throwable?) {

            }

        })

        val callBestSellers: Call<List<BestSellers>> = EbookApiClient.getClient.getBestSellers()
        callBestSellers.enqueue(object : Callback<List<BestSellers>> {

            override fun onResponse(
                call: Call<List<BestSellers>>?,
                response: Response<List<BestSellers>>?
            ) {

                bestSellersList.addAll(response!!.body()!!)
                bestSellersView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<BestSellers>>?, t: Throwable?) {

            }

        })


    }

}
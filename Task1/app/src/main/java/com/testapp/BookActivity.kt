package com.testapp

import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_book.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BookActivity : AppCompatActivity() {

    lateinit var similarView: RecyclerView
    var similarList = ArrayList<Similar>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        val intent = intent

        val titleName = intent.getStringExtra("title")
        book_title.text = titleName

        val authorName = intent.getStringExtra("author")
        book_author.text = authorName

        val score = intent.getStringExtra("score")
        book_score.text = score

        val image = intent.getParcelableExtra<Bitmap>("image")
        book_image.setImageBitmap(image)


        similarView = findViewById<RecyclerView>(R.id.similar_view)
        similarView.adapter = SimilarAdapter(similarList, this)
        similarView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        getData()

        toolbar.setNavigationOnClickListener {
            finish()
        }

    }


    private fun getData() {
        val callSimilar: Call<List<Similar>> = EbookApiClient.getClient.getSimilar()
        callSimilar.enqueue(object : Callback<List<Similar>> {

            override fun onResponse(
                call: Call<List<Similar>>?,
                response: Response<List<Similar>>?
            ) {
                similarList.addAll(response!!.body()!!)
                similarView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Similar>>?, t: Throwable?) {

            }

        })

    }
}
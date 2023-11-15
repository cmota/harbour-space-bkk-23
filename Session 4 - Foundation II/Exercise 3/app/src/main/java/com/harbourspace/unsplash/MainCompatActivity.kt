package com.harbourspace.unsplash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainCompatActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val images = listOf(
      R.drawable.img1,
      R.drawable.img2,
      R.drawable.img3,
      R.drawable.img4
    )

    findViewById<RecyclerView>(R.id.rv_feed).apply {
      setHasFixedSize(true)
      layoutManager = LinearLayoutManager(context)
      adapter = MainAdapter(images) {
        startActivity(Intent(this@MainCompatActivity, DetailsActivity::class.java))
      }
    }
  }
}
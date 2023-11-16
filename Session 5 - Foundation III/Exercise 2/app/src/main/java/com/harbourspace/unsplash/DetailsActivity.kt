package com.harbourspace.unsplash

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.harbourspace.unsplash.utils.EXTRA_IMAGE

class DetailsActivity: AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_details)

    findViewById<ImageView>(R.id.iv_preview).setOnClickListener {
      val intent = Intent(this, ImageViewerActivity::class.java)
      intent.putExtra(EXTRA_IMAGE, R.drawable.bkk_loha_prasat)
      startActivity(intent)
    }
  }
}
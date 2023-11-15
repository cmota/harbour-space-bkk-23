package com.harbourspace.unsplash

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class CounterActivity: AppCompatActivity() {

  lateinit var viewModel : CounterViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_counter)

    viewModel = ViewModelProvider(this)[CounterViewModel::class.java]

    val tvCounter = findViewById<TextView>(R.id.tv_counter)
    findViewById<Button>(R.id.btn_counter).setOnClickListener {
      viewModel.increment()
    }

    viewModel.number.observe(this){ number ->
      tvCounter.text = number.toString()
    }
  }
}
package com.harbourspace.unsplash

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.harbourspace.unsplash.ui.theme.UnsplashTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    Toast.makeText(applicationContext, "onCreate", Toast.LENGTH_SHORT).show()

    setContent {
      UnsplashTheme {
        Log.d("MainActivity", "Run...")
        Column(
          modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
        ) {
          Button(onClick = {
            val intent = Intent(this@MainActivity, ExercisesActivity::class.java)
            startActivity(intent)
          }) {
            Text("Exercises")
          }
        }
      }
    }
  }

  override fun onResume() {
    super.onResume()
    Log.d("MainActivity", "onResume")
    Toast.makeText(applicationContext, "onResume", Toast.LENGTH_SHORT).show()
  }

  override fun onPause() {
    Log.d("MainActivity", "onPause")
    Toast.makeText(applicationContext, "onPause", Toast.LENGTH_SHORT).show()

    super.onPause()
  }

  override fun onDestroy() {
    Log.d("MainActivity", "onDestroy")
    Toast.makeText(applicationContext, "onDestroy", Toast.LENGTH_SHORT).show()

    super.onDestroy()
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  UnsplashTheme {
    Greeting("Android")
  }
}
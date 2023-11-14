package com.harbourspace.unsplash

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Greeting("Android")
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
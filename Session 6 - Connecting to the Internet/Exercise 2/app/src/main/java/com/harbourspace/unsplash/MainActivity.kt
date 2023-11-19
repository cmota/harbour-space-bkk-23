package com.harbourspace.unsplash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.harbourspace.unsplash.api.UnsplashApiProvider
import com.harbourspace.unsplash.data.cb.UnsplashResult
import com.harbourspace.unsplash.data.model.UnsplashItem
import com.harbourspace.unsplash.ui.theme.UnsplashTheme

class MainActivity : ComponentActivity(), UnsplashResult {

  private lateinit var unsplashImages: MutableState<List<UnsplashItem>>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val provider = UnsplashApiProvider()
    provider.fetchImages(this)

    setContent {
      UnsplashTheme {
        unsplashImages = remember { mutableStateOf(emptyList()) }

        LazyColumn {
          items(unsplashImages.value) { image ->
            Card(
              modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(10.dp))
            ) {
              Column(
                modifier = Modifier
                  .fillMaxSize()
                  .padding(12.dp),
                verticalArrangement = Arrangement.Bottom
              ) {
                Text(text = image.description ?: "")

                Spacer(modifier = Modifier.height(4.dp))

                Text(text = image.user.name)
              }
            }
          }
        }
      }
    }
  }

  override fun onDataFetchedSuccess(images: List<UnsplashItem>) {
    unsplashImages.value = images
  }

  override fun onDataFetchedFailed() {
    unsplashImages.value = emptyList()
  }
}
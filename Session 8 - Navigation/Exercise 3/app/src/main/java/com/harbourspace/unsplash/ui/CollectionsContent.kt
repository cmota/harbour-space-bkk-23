package com.harbourspace.unsplash.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.harbourspace.unsplash.R
import com.harbourspace.unsplash.UnsplashViewModel

@Composable
fun CollectionsContent(
  unsplashViewModel: UnsplashViewModel
) {
  val collections = unsplashViewModel.collections.observeAsState(emptyList())

  LazyColumn {
    item {
      Spacer(modifier = Modifier.height(16.dp))
    }

    items(collections.value) { collection ->
      Surface(
        modifier = Modifier
          .fillMaxWidth()
          .height(250.dp)
          .padding(8.dp)
          .clip(RoundedCornerShape(16.dp))
      ) {

        val painter = rememberAsyncImagePainter(
          model = ImageRequest.Builder(LocalContext.current)
            .data(collection.cover_photo.urls.regular)
            .build()
        )

        Image(
          painter = painter,
          contentDescription = stringResource(id = R.string.description_image_preview),
          contentScale = ContentScale.Crop
        )
      }
    }
  }
}
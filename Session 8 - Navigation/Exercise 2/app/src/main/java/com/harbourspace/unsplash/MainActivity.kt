package com.harbourspace.unsplash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.harbourspace.unsplash.data.model.UnsplashItem
import com.harbourspace.unsplash.ui.CollectionsContent
import com.harbourspace.unsplash.ui.ImagesContent
import com.harbourspace.unsplash.ui.theme.UnsplashTheme
import com.harbourspace.unsplash.utils.EXTRA_IMAGE

private enum class Tab(@StringRes val tab: Int) {
  HOME(R.string.main_tab_images),
  COLLECTIONS(R.string.main_tab_collections)
}

class MainActivity : ComponentActivity() {

  private val unsplashViewModel: UnsplashViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    unsplashViewModel.fetchImages()

    setContent {
      UnsplashTheme {
        val selected = remember { mutableIntStateOf(0) }

        Column {

          val actions = listOf(Tab.HOME, Tab.COLLECTIONS)
          TabRow(
            selectedTabIndex = selected.intValue,
            modifier = Modifier.height(48.dp)
          ) {
            actions.forEachIndexed { index, _ ->
              Tab(
                selected = selected.intValue == index,
                onClick = { selected.intValue = index },
                modifier = Modifier.height(48.dp)
              ) {
                Text(
                  text = stringResource(id = Tab.entries[index].tab)
                )
              }
            }
          }

          when(selected.intValue) {
            Tab.HOME.ordinal -> {
              ImagesContent(
                unsplashViewModel = unsplashViewModel,
                onAction = { item -> openDetails(item) }
              )
            }

            Tab.COLLECTIONS.ordinal -> {
              CollectionsContent(
                unsplashViewModel = unsplashViewModel
              )
            }
          }
        }
      }
    }
  }

  private fun openDetails(image: UnsplashItem) {
    val intent = Intent(this@MainActivity, DetailsActivity::class.java)
    intent.putExtra(EXTRA_IMAGE, image.urls.regular)
    startActivity(intent)
  }
}
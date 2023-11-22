package com.harbourspace.unsplash.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.harbourspace.unsplash.Tab
import com.harbourspace.unsplash.UnsplashViewModel
import com.harbourspace.unsplash.data.model.UnsplashItem

@Composable
fun ImagesScreen(
  unsplashViewModel: UnsplashViewModel,
  onAction: (UnsplashItem) -> Unit
) {
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
          onAction = { item -> onAction(item) }
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
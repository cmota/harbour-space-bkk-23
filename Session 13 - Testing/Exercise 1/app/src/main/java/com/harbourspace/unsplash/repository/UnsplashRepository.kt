package com.harbourspace.unsplash.repository

import androidx.lifecycle.LiveData
import com.harbourspace.unsplash.data.model.UnsplashItem

class UnsplashRepository(private val dao: UnsplashDAO) {

    val items: LiveData<List<UnsplashItem>> = dao.getAllImages()

    fun insert(item: UnsplashItem) {
        AppDatabase.databaseWriteExecutor.execute {
            dao.insertImage(item)
        }
    }
}
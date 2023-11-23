package com.harbourspace.unsplash.data.model

import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Urls(
    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val thumb: String
)
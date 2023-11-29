package com.harbourspace.unsplash.data.model

import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Links(
    val download: String?,
    val download_location: String?,
    val html: String?,
    val self: String?
)
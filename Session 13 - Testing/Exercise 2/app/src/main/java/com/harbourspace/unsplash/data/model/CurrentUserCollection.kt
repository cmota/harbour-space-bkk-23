package com.harbourspace.unsplash.data.model

import androidx.room.Entity
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class CurrentUserCollection(
    val cover_photo: @Contextual Any,
    val id: Int,
    val last_collected_at: String,
    val published_at: String,
    val title: String,
    val updated_at: String,
    val user: @Contextual Any
)
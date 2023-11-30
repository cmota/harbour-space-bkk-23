package com.harbourspace.unsplash.data.model

import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class ProfileImage(
    val large: String,
    val medium: String,
    val small: String
)
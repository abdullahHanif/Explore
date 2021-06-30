package com.al.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.al.data.model.typeconverter.TypeConverterz
import java.io.Serializable

@Entity
@TypeConverters(TypeConverterz::class)
data class ImageResponse(
    val total: Double,
    val totalHits: Double,
    val hits: ArrayList<Image>
): Serializable

@Entity
data class Image(
    @PrimaryKey
    val id: Double,
    val largeImageURL: String,
    val user: String,
    val userImageURL: String,
    val previewURL: String,
    val tags: String,
): Serializable



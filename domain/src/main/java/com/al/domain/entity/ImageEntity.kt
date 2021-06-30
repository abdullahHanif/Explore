package com.al.domain.entity

data class ImageEntity(
    val id: Double,
    val largeImageURL: String,
    val user: String,
    val userImageURL: String,
    val previewURL: String,
    val tags: String
)
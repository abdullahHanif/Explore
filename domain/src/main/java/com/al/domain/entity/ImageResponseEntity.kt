package com.al.domain.entity

data class ImageResponseEntity(
    val total: Double,
    val totalHits: Double,
    val hits: ArrayList<ImageEntity>
)

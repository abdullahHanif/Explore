package com.al.domain.entity

import java.io.Serializable

data class ImageResponseEntity(
    val total: Double,
    val totalHits: Double,
    val hits: ArrayList<ImageEntity>
):Serializable

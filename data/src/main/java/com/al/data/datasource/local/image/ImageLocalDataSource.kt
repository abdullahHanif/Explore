package com.al.data.datasource.local.image

import com.al.data.model.Image


interface ImageLocalDataSource {
    suspend fun getImages(pageNo: Int): List<Image>

    suspend fun saveAll(images: List<Image>)

    suspend fun deleteAll()
}
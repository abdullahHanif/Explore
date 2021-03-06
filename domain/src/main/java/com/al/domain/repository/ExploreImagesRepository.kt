package com.al.domain.repository

import com.al.domain.entity.ImageResponseEntity
import kotlinx.coroutines.flow.Flow

interface ExploreImagesRepository {
    suspend fun fetchImages(pageNo: Int): Flow<ImageResponseEntity>

    suspend fun deleteSavedImages()
}
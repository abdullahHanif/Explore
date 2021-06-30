package com.al.domain.repository

import com.al.domain.entity.ImageEntity
import kotlinx.coroutines.flow.Flow

interface ExploreImagesRepository {
    suspend fun fetchImages(pageNo: Int): Flow<List<ImageEntity>>

    suspend fun deleteSavedImages()
}
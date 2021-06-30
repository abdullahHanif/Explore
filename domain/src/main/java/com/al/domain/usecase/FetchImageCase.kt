package com.al.domain.usecase

import com.al.domain.entity.ImageEntity
import com.al.domain.repository.ExploreImagesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchImageCase @Inject constructor(private val exploreImagesRepository: ExploreImagesRepository) {

    @Throws(Exception::class)
    suspend operator fun invoke(page: Int): Flow<List<ImageEntity>> =
        exploreImagesRepository.fetchImages(page)
}
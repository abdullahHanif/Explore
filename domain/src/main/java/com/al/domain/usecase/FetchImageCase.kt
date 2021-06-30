package com.al.domain.usecase

import com.al.domain.entity.ImageResponseEntity
import com.al.domain.repository.ExploreImagesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchImageCase @Inject constructor(private val exploreImagesRepository: ExploreImagesRepository) {

    @Throws(Exception::class)
    suspend operator fun invoke(page: Int): Flow<ImageResponseEntity> =
        exploreImagesRepository.fetchImages(page)
}
package com.al.data.datasource.remote.network.image

import com.al.data.datasource.remote.api.ExploreImageService
import com.al.data.model.ImageResponse
import javax.inject.Inject

class ImageRemoteDataSourceImpl @Inject constructor(private val service: ExploreImageService) :
    ImageRemoteDataSource {

    @Throws(Exception::class)
    override suspend fun getFetchImages(pageNo: Int): ImageResponse {
        return try {
            service.getImages(pageNo)
        } catch (exception: Exception) {
            throw exception
        }
    }
}


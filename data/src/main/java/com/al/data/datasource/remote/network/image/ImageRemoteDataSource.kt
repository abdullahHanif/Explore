package com.al.data.datasource.remote.network.image

import com.al.data.model.ImageResponse

interface ImageRemoteDataSource {
    @Throws(Exception :: class)
    suspend fun getFetchImages(pageNo: Int): ImageResponse
}
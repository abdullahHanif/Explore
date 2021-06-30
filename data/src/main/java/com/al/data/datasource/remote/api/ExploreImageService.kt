package com.al.data.datasource.remote.api

import com.al.data.model.ImageResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ExploreImageService {
    @GET("api")
    suspend fun getImages(@Path("id") pageNo: Int): ImageResponse
}
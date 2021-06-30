package com.al.data.datasource.remote.api

import com.al.data.model.ImageResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ExploreImageService {
    @GET("api/")
    suspend fun getImages(@QueryMap map : HashMap<String, String>): ImageResponse
}
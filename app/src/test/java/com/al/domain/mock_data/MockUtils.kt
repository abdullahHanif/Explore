package com.al.domain.mock_data

import androidx.annotation.WorkerThread
import com.al.domain.entity.ImageEntity
import com.al.domain.entity.ImageResponseEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object MockUtil {

    fun mockImageResponseEntity(): ImageResponseEntity {
        return ImageResponseEntity(1415462.0, 500.0, mockImageList())
    }

    fun mockImageList(): ArrayList<ImageEntity> =
        listOf(mockImageEntity()) as ArrayList<ImageEntity>

    private fun mockImageEntity(): ImageEntity {
        return ImageEntity(
            30632.0,
            "https://pixabay.com/get/g09fc48a65f4396902f4e0b246c5d87ab739510f2a520a8faada034b576e4e51e8c45d72671417cc0fe56ae2c9c1ee8ef45c6e7922dc0a1ae1cf5139dc69d7fd3_1280.jpg",
            "anncapictures",
            "https://cdn.pixabay.com/photo/2018/01/05/16/24/rose-3063284_150.jpg",
            "https://cdn.pixabay.com/user/2015/11/27/06-58-54-609_250x250.jpg",
            "rose, flower, petal"
        )
    }

    @WorkerThread
    fun getMockImageResponseFlow(): Flow<ImageResponseEntity> = flow {
        emit(mockImageResponseEntity())
    }
}


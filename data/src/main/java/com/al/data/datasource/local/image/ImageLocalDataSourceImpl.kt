package com.al.data.datasource.local.image

import com.al.data.db.dao.ImageDao
import com.al.data.model.Image
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageLocalDataSourceImpl @Inject constructor(private val imageDao: ImageDao) :
    ImageLocalDataSource {

    override suspend fun getImages(pageNo: Int): List<Image> = imageDao.getAll()

    override suspend fun saveAll(images: List<Image>) {
        images.forEach {
            imageDao.insert(it)
        }
    }

    override suspend fun deleteAll() = imageDao.truncate()
}
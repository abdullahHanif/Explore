package com.al.data.repository

import com.al.data.datasource.local.image.ImageLocalDataSource
import com.al.data.datasource.remote.network.image.ImageRemoteDataSource
import com.al.data.mapper.ImageMapper
import com.al.domain.entity.ImageEntity
import com.al.domain.repository.ExploreImagesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExploreImagesRepositoryImpl @Inject constructor(
    private val localSource: ImageLocalDataSource,
    private val remoteDataSource: ImageRemoteDataSource
) : ExploreImagesRepository {

    @Throws(Exception::class)
    override suspend fun fetchImages(pageNo: Int): Flow<List<ImageEntity>> = flow {
        val lst = ArrayList<ImageEntity>()
        //fetch it, map it and release it to Domain with flow
        try {
            val data = remoteDataSource.getFetchImages(pageNo)
            localSource.deleteAll()
            localSource.saveAll(data.hits)

            //mapping it into domain type pojo convention and emit
            localSource.getImages(pageNo).forEach {
                lst.add(ImageMapper.fromDataToDomainType(it))
            }

            emit(lst)
        } catch (exception: Exception) {
            //Toast.makeText(context, "$exception.localizedMessage", Toast.LENGTH_LONG).show()
        }
    }


    override suspend fun deleteSavedImages() {
        localSource.deleteAll()
    }
}
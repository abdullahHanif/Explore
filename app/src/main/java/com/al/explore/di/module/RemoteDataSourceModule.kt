package com.al.explore.di.module

import com.al.data.datasource.remote.network.image.ImageRemoteDataSource
import com.al.data.datasource.remote.network.image.ImageRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun provideRemoteDataSource(remoteDataSource: ImageRemoteDataSourceImpl): ImageRemoteDataSource

}
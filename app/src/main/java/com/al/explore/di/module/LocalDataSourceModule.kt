package com.al.explore.di.module


import com.al.data.datasource.local.image.ImageLocalDataSource
import com.al.data.datasource.local.image.ImageLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun provideLocalDataSource(imageLocalDataSourceImpl: ImageLocalDataSourceImpl): ImageLocalDataSource

}
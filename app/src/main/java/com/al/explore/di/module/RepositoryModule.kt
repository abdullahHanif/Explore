package com.al.explore.di.module

import com.al.data.repository.ExploreImagesRepositoryImpl
import com.al.domain.repository.ExploreImagesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideRepository(repository: ExploreImagesRepositoryImpl): ExploreImagesRepository

}
package com.al.explore.di.module

import com.al.domain.repository.ExploreImagesRepository
import com.al.domain.usecase.FetchImageCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
 object UseCaseModule {

    @Singleton
    @Provides
    fun provideImageFetchImageCase(exploreImagesRepository: ExploreImagesRepository) =
        FetchImageCase(exploreImagesRepository)
}
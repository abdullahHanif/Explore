package com.al.explore.di.module

import android.content.Context
import androidx.room.Room
import com.al.data.db.ExploreDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): ExploreDatabase =
        Room.databaseBuilder(context, ExploreDatabase::class.java, ExploreDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()


    @Singleton
    @Provides
    fun provideImageDao(db: ExploreDatabase) = db.imageDao()

}
package com.al.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.al.data.db.dao.ImageDao
import com.al.data.model.ImageResponse

@Database(entities = [ImageResponse::class], version = 1, exportSchema = false)
abstract class  ExploreDatabase : RoomDatabase() {
    abstract fun imageDao(): ImageDao

    companion object {
        val DATABASE_NAME: String = "explore_db"
    }
}
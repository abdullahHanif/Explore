package com.al.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.al.data.model.Image

@Dao
interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(image: Image): Long

    @Query("SELECT * FROM Image")
    suspend fun getAll(): List<Image>

    @Query("Delete FROM Image")
    suspend fun truncate()
}
package com.al.data.datasource.local

import android.content.Context
import com.al.data.db.ExploreDatabase
import javax.inject.Inject

abstract class LocalSource constructor() {
    @Inject
    lateinit var db: ExploreDatabase

    @Inject
    lateinit var context: Context
}
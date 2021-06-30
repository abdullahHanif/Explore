package com.al.data.model.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class TypeConverterz {
    @TypeConverter
    inline fun <reified T> stringToList(json: String): List<T> {
        val gson = Gson()
        val type = object : TypeToken<List<T>>() {

        }.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    inline fun <reified T> ListToString(list: List<T>): String {
        val gson = Gson()
        val type = object : TypeToken<List<T>>() {}.type
        return gson.toJson(list, type)
    }
}

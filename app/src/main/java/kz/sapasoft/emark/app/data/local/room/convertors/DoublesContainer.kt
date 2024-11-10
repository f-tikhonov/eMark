package kz.sapasoft.emark.app.data.local.room.convertors

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DoublesContainer {

    @TypeConverter
    fun fromString(value: String): List<Double> {
        val listType = object : TypeToken<List<Double>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Double>): String {
        return Gson().toJson(list)
    }
}
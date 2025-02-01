package kz.sapasoft.emark.app.data.local.room.convertors

import android.util.Log
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kz.sapasoft.emark.app.domain.model.FieldModel
import kz.sapasoft.emark.app.domain.model.ImageDataModel
import java.io.File

class FieldModelConverters {

    @TypeConverter
    fun fromString(value: String): List<FieldModel>? {
        val listType = object : TypeToken<List<FieldModel>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<FieldModel>?): String {
        return Gson().toJson(list)
    }
}

class MetaDataConverter {

    @TypeConverter
    fun fromMetaData(metadata: ImageDataModel.MetaData?): String? {
        return Gson().toJson(metadata)
    }

    @TypeConverter
    fun toMetaData(metadataString: String?): ImageDataModel.MetaData? {
        val type = object : TypeToken<ImageDataModel.MetaData>() {}.type
        return Gson().fromJson(metadataString, type)
    }
}

class FileConverter {

    @TypeConverter
    fun fromFile(file: File?): String? {
        return file?.absolutePath
    }

    @TypeConverter
    fun toFile(filePath: String?): File? {
        return filePath?.let { File(it) }
    }
}

class MapConverter {

    @TypeConverter
    fun fromMap(map: Map<String, String>?): String {
        return Gson().toJson(map)
    }

    @TypeConverter
    fun toMap(mapString: String): Map<String, String> {
        val type = object : TypeToken<Map<String, String>>() {}.type
        return Gson().fromJson(mapString, type)
    }
}
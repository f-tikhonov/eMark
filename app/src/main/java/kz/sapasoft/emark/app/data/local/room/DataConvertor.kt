import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class DataConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromStringList(list: List<String>?): String? {
        return list?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toStringList(data: String?): List<String>? {
        return data?.let { gson.fromJson(it, object : TypeToken<List<String>>() {}.type) }
    }

    @TypeConverter
    fun fromDoubleList(list: List<Double>?): String? {
        return list?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toDoubleList(data: String?): List<Double>? {
        return data?.let { gson.fromJson(it, object : TypeToken<List<Double>>() {}.type) }
    }

    @TypeConverter
    fun fromStringMap(map: Map<String, String>?): String? {
        return map?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toStringMap(data: String?): Map<String, String>? {
        return data?.let { gson.fromJson(it, object : TypeToken<Map<String, String>>() {}.type) }
    }

    @TypeConverter
    fun fromFile(file: File?): String? {
        return file?.absolutePath
    }

    @TypeConverter
    fun toFile(path: String?): File? {
        return path?.let { File(it) }
    }
}
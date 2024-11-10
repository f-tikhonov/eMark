package kz.sapasoft.emark.app.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateConverter {

    fun stringToDate(string: String?, pattern: String): Date? {
        if (string.isNullOrEmpty()) return null
        return try {
            SimpleDateFormat(pattern, Locale.getDefault()).parse(string)
        } catch (e: ParseException) {
            null
        }
    }

    fun dateToString(date: Date, pattern: String): String {
        return SimpleDateFormat(pattern, Locale.getDefault()).format(date)
    }

    fun millisToDate(milliSeconds: Long?): Date? {
        return milliSeconds?.let {
            Calendar.getInstance().apply {
                timeInMillis = it
            }.time
        }
    }

    fun millisToString(milliSeconds: Long?, pattern: String): String {
        val date = millisToDate(milliSeconds) ?: return ""
        return dateToString(date, pattern)
    }

    fun stringToMillis(string: String?, pattern: String): Long? {
        val date = stringToDate(string, pattern)
        return date?.time
    }
}
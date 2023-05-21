package v.sivasubramaniam.calendar.feature_reminder.data.database.converters

import androidx.room.TypeConverter

class DateStringConverter {

    @TypeConverter
    fun datesToString(dates: List<String>): String = dates.toString()

    @TypeConverter
    fun stringToDates(string: String): List<String> {
        return string.removeSurrounding("[", "]").replace(" ", "").split(",")
    }
}
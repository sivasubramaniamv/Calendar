package v.sivasubramaniam.calendar.feature_reminder.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import v.sivasubramaniam.calendar.feature_reminder.data.database.converters.DateStringConverter

@Entity(tableName = "reminder_table")
data class ReminderEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val startDateTime: String,
    val repetition: String,
    @field:TypeConverters(DateStringConverter::class)
    val recurrence: List<String>,
    val isDone: Boolean
)
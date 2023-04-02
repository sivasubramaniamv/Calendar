package v.sivasubramaniam.calendar.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import v.sivasubramaniam.calendar.feature_reminder.data.database.ReminderDao
import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderResponse

@Database(entities = [ReminderResponse::class], version = 1, exportSchema = false)
abstract class CalendarDb: RoomDatabase() {
    abstract val reminderDao: ReminderDao
}
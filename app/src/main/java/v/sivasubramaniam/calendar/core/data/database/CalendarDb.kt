package v.sivasubramaniam.calendar.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import v.sivasubramaniam.calendar.feature_reminder.data.database.ReminderDaoImpl
import v.sivasubramaniam.calendar.feature_reminder.data.database.entity.ReminderEntity

@Database(entities = [ReminderEntity::class], version = 1, exportSchema = false)
abstract class CalendarDb: RoomDatabase() {
    abstract val reminderDaoImpl: ReminderDaoImpl
}
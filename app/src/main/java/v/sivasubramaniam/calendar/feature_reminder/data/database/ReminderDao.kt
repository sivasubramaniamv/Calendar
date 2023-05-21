package v.sivasubramaniam.calendar.feature_reminder.data.database

import kotlinx.coroutines.flow.Flow
import v.sivasubramaniam.calendar.feature_reminder.data.database.entity.ReminderEntity

interface ReminderDao {

    suspend fun insertReminder(reminder: ReminderEntity)

    suspend fun insertReminders(reminders: List<ReminderEntity>)

    suspend fun getReminder(id: String): ReminderEntity

    fun getReminders(): Flow<List<ReminderEntity>>

    suspend fun updateReminder(reminder: ReminderEntity)

    suspend fun deleteReminder(reminder: ReminderEntity)
}
package v.sivasubramaniam.calendar.feature_reminder.domain.repository

interface ReminderRepository {

    suspend fun addReminder()

    suspend fun getReminders()

    suspend fun updateReminder()

    suspend fun deleteReminder()
}
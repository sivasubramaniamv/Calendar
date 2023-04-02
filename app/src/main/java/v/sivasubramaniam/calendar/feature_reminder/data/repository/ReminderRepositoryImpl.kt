package v.sivasubramaniam.calendar.feature_reminder.data.repository

import io.ktor.http.*
import v.sivasubramaniam.calendar.core.data.database.CalendarDb
import v.sivasubramaniam.calendar.feature_reminder.data.remote.ReminderService
import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderRequest
import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderResponse
import v.sivasubramaniam.calendar.feature_reminder.domain.repository.ReminderRepository

class ReminderRepositoryImpl(
    private val service: ReminderService, private val database: CalendarDb
) : ReminderRepository {
    override suspend fun populateDb() {
        val reminders = service.getReminders()
        if (reminders.isNotEmpty()) database.reminderDao.insertReminders(reminders)
    }

    override suspend fun addReminder(reminder: ReminderRequest) {
        service.postReminder(reminder)?.let { response ->
            database.reminderDao.createReminder(response)
        }
    }

    override fun getReminders() = database.reminderDao.readReminders()

    override suspend fun getReminder(id: Int) = database.reminderDao.readReminder(id)

    override suspend fun updateReminder(reminder: ReminderResponse) {
        val statusCode = service.putReminder(reminder)
        if (statusCode.isSuccess()) database.reminderDao.updateReminder(reminder)
    }

    override suspend fun deleteReminder(reminder: ReminderResponse) {
        val statusCode = service.deleteReminder(reminder)
        if (statusCode.isSuccess()) database.reminderDao.deleteReminder(reminder)
    }
}
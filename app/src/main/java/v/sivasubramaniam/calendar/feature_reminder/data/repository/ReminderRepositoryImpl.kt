package v.sivasubramaniam.calendar.feature_reminder.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import v.sivasubramaniam.calendar.core.util.Resource
import v.sivasubramaniam.calendar.core.util.SimpleResource
import v.sivasubramaniam.calendar.feature_reminder.data.database.ReminderDao
import v.sivasubramaniam.calendar.feature_reminder.data.mappers.toDomain
import v.sivasubramaniam.calendar.feature_reminder.data.mappers.toDto
import v.sivasubramaniam.calendar.feature_reminder.data.mappers.toEntity
import v.sivasubramaniam.calendar.feature_reminder.data.remote.ReminderService
import v.sivasubramaniam.calendar.feature_reminder.domain.model.Reminder
import v.sivasubramaniam.calendar.feature_reminder.domain.repository.ReminderRepository

class ReminderRepositoryImpl(
    private val service: ReminderService, private val dao: ReminderDao
) : ReminderRepository {
    override suspend fun fetchReminders() {
        val reminders = service.getReminders()
        if (reminders.isNotEmpty()) {
            dao.insertReminders(
                reminders.map { it.toEntity() }
            )
        }
    }

    override suspend fun addReminder(reminder: Reminder): SimpleResource {
        val response = service.postReminder(reminder.toDto())

        return if (response.successful) {
            response.data?.toEntity()?.let { dao.insertReminder(it) }
            Resource.Success(Unit)
        } else {
            response.message?.let { msg ->
                Resource.Error(msg)
            } ?: Resource.Error("Unknown error")
        }
    }

    override fun getReminders(): Flow<List<Reminder>> {
        return dao.getReminders().map { reminderEntities ->
            reminderEntities.map {
                it.toDomain()
            }
        }
    }

    override suspend fun getReminder(id: String): Resource<Reminder> {
        return try {
            val reminder = dao.getReminder(id).toDomain()
            Resource.Success(reminder)
        } catch (e: Exception) {
            Resource.Error("Unknown error")
        }
    }

    override suspend fun updateReminder(reminder: Reminder): SimpleResource {
        val response = service.putReminder(reminder.toDto())

        return if (response.successful) {
            dao.updateReminder(reminder.toEntity())
            Resource.Success(Unit)
        } else {
            response.message?.let { msg ->
                Resource.Error(msg)
            } ?: Resource.Error("Unknown error")
        }
    }

    override suspend fun deleteReminder(reminder: Reminder): SimpleResource {
        val response = service.deleteReminder(reminder.toDto())

        return if (response.successful) {
            dao.deleteReminder(reminder.toEntity())
            Resource.Success(Unit)
        } else {
            response.message?.let { msg ->
                Resource.Error(msg)
            } ?: Resource.Error("Unknown error")
        }
    }
}
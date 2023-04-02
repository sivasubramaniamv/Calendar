package v.sivasubramaniam.calendar.feature_reminder.domain.repository

import kotlinx.coroutines.flow.Flow
import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderRequest
import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderResponse

interface ReminderRepository {

    suspend fun populateDb()

    suspend fun addReminder(reminder: ReminderRequest)

    fun getReminders(): Flow<List<ReminderResponse>>

    suspend fun getReminder(id: Int): ReminderResponse

    suspend fun updateReminder(reminder: ReminderResponse)

    suspend fun deleteReminder(reminder: ReminderResponse)
}
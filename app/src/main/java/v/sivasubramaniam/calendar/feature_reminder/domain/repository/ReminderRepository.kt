package v.sivasubramaniam.calendar.feature_reminder.domain.repository

import kotlinx.coroutines.flow.Flow
import v.sivasubramaniam.calendar.core.util.Resource
import v.sivasubramaniam.calendar.core.util.SimpleResource
import v.sivasubramaniam.calendar.feature_reminder.domain.model.Reminder

interface ReminderRepository {

    suspend fun fetchReminders()

    suspend fun addReminder(reminder: Reminder): SimpleResource

    fun getReminders(): Flow<List<Reminder>>

    suspend fun getReminder(id: String): Resource<Reminder>

    suspend fun updateReminder(reminder: Reminder): SimpleResource

    suspend fun deleteReminder(reminder: Reminder): SimpleResource
}
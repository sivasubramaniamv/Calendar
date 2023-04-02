package v.sivasubramaniam.calendar.feature_reminder.data.remote

import io.ktor.http.*
import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderRequest
import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderResponse

interface ReminderService {

    suspend fun postReminder(reminder: ReminderRequest): ReminderResponse?

    suspend fun getReminders(): List<ReminderResponse>

    suspend fun putReminder(reminder: ReminderResponse): HttpStatusCode

    suspend fun deleteReminder(reminder: ReminderResponse): HttpStatusCode
}
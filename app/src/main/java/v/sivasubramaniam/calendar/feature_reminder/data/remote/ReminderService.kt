package v.sivasubramaniam.calendar.feature_reminder.data.remote

import v.sivasubramaniam.calendar.core.data.dto.response.BasicApiResponse
import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderDto

interface ReminderService {

    suspend fun postReminder(reminder: ReminderDto): BasicApiResponse<ReminderDto>

    suspend fun getReminders(): List<ReminderDto>

    suspend fun putReminder(reminder: ReminderDto): BasicApiResponse<Unit>

    suspend fun deleteReminder(reminder: ReminderDto): BasicApiResponse<Unit>
}
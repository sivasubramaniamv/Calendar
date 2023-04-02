package v.sivasubramaniam.calendar.feature_reminder.data.remote

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderRequest
import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderResponse
import javax.inject.Inject

class ReminderServiceImpl @Inject constructor(
    private val client: HttpClient
): ReminderService {

    override suspend fun postReminder(reminder: ReminderRequest): ReminderResponse? {
        return try {
            client.post<ReminderResponse> {
                url(HttpRoutes.REMINDERS)
                contentType(ContentType.Application.Json)
                body = reminder
            }
        } catch (e: ResponseException) {
            println(e.response.status)
            null
        }
    }

    override suspend fun getReminders(): List<ReminderResponse> {
        return try {
            client.get {
                url(HttpRoutes.REMINDERS)
            }
        } catch (e: ResponseException) {
            println(e.response.status)
            emptyList()
        }
    }

    override suspend fun putReminder(reminder: ReminderResponse): HttpStatusCode {
        return try {
            client.put(
                urlString = HttpRoutes.REMINDERS + "/${reminder.id}"
            ) {
                contentType(ContentType.Application.Json)
                body = reminder
            }
        } catch (e: ResponseException) {
            println(e.response.status)
            e.response.status
        }
    }

    override suspend fun deleteReminder(reminder: ReminderResponse): HttpStatusCode {
        return try {
            client.delete(
                urlString = HttpRoutes.REMINDERS + "/${reminder.id}"
            )
        } catch (e: ResponseException) {
            println(e.response.status)
            e.response.status
        }
    }
}
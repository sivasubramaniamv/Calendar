package v.sivasubramaniam.calendar.feature_reminder.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.features.ResponseException
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import v.sivasubramaniam.calendar.core.data.dto.response.BasicApiResponse
import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderDto
import javax.inject.Inject

class ReminderServiceImpl @Inject constructor(
    private val client: HttpClient
): ReminderService {

    override suspend fun postReminder(reminder: ReminderDto): BasicApiResponse<ReminderDto> {
        return try {
            val dto = client.post<ReminderDto> {
                url(HttpRoutes.REMINDERS)
                contentType(ContentType.Application.Json)
                body = reminder
            }
            BasicApiResponse(
                successful = true,
                data = dto
            )
        } catch (e: ResponseException) {
            println(e.response.status.toString())
            BasicApiResponse(
                successful = false,
                message = e.response.status.description
            )
        } catch (e: Exception) {
            e.printStackTrace()
            BasicApiResponse(false)
        }
    }

    override suspend fun getReminders(): List<ReminderDto> {
        return try {
            client.get {
                url(HttpRoutes.REMINDERS)
            }
        } catch (e: ResponseException) {
            println(e.response.status.toString())
            emptyList()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    override suspend fun putReminder(reminder: ReminderDto): BasicApiResponse<Unit> {
        return try {
            val response: HttpResponse = client.put(
                urlString = HttpRoutes.REMINDERS + "/${reminder.id}"
            ) {
                contentType(ContentType.Application.Json)
                body = reminder
            }
            BasicApiResponse(response.status.isSuccess())
        } catch (e: ResponseException) {
            println(e.response.status.toString())
            BasicApiResponse(
                successful = false,
                message = e.response.status.description
            )
        } catch (e: Exception) {
            e.printStackTrace()
            BasicApiResponse(false)
        }
    }

    override suspend fun deleteReminder(reminder: ReminderDto): BasicApiResponse<Unit> {
        return try {
            val response: HttpResponse = client.delete(
                urlString = HttpRoutes.REMINDERS + "/${reminder.id}"
            )
            BasicApiResponse(response.status.isSuccess())
        } catch (e: ResponseException) {
            println(e.response.status.toString())
            BasicApiResponse(
                successful = false,
                message = e.response.status.description
            )
        } catch (e: Exception) {
            e.printStackTrace()
            BasicApiResponse(false)
        }
    }
}
package v.sivasubramaniam.calendar.feature_reminder.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ReminderDto(
    val id: String,
    val title: String,
    val startDateTime: String,
    val repetition: String,
    val recurrence: List<String>,
    val isDone: Boolean
)
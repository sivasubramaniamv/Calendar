package v.sivasubramaniam.calendar.feature_reminder.domain.model

import java.time.LocalDateTime

data class Reminder(
    val id: String,
    val title: String,
    val startDateTime: LocalDateTime,
    val repetition: String,
    var recurrence: List<LocalDateTime>,
    var isDone: Boolean
)

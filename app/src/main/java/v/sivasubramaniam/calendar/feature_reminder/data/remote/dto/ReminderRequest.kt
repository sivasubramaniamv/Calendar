package v.sivasubramaniam.calendar.feature_reminder.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ReminderRequest(
    var title: String,
    var account: String,
    var day: Int,
    var month: Int,
    var year: Int,
    var hour: Int,
    var minute: Int,
    var repetition: String,
    var isDone: Boolean
)

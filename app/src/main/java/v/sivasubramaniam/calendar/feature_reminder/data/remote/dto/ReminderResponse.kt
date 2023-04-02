package v.sivasubramaniam.calendar.feature_reminder.data.remote.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "reminder_table")
data class ReminderResponse(
    @PrimaryKey
    val id: Int,
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
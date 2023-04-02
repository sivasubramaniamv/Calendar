package v.sivasubramaniam.calendar.feature_reminder.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderResponse

@Dao
interface ReminderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminders(reminders: List<ReminderResponse>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createReminder(reminder: ReminderResponse)

    @Query("SELECT * FROM reminder_table ORDER BY id DESC")
    fun readReminders(): Flow<List<ReminderResponse>>

    @Query("SELECT * from reminder_table WHERE id = :id")
    suspend fun readReminder(id: Int): ReminderResponse

    @Update
    suspend fun updateReminder(reminder: ReminderResponse)

    @Delete
    suspend fun deleteReminder(reminder: ReminderResponse)
}
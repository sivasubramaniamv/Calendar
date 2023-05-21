package v.sivasubramaniam.calendar.feature_reminder.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import v.sivasubramaniam.calendar.feature_reminder.data.database.entity.ReminderEntity

@Dao
interface ReminderDaoImpl: ReminderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun insertReminder(reminder: ReminderEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun insertReminders(reminders: List<ReminderEntity>)

    @Query("SELECT * from reminder_table WHERE id = :id")
    override suspend fun getReminder(id: String): ReminderEntity

    @Query("SELECT * FROM reminder_table ORDER BY id DESC")
    override fun getReminders(): Flow<List<ReminderEntity>>

    @Update
    override suspend fun updateReminder(reminder: ReminderEntity)

    @Delete
    override suspend fun deleteReminder(reminder: ReminderEntity)
}
package v.sivasubramaniam.calendar.feature_reminder.domain.use_case

import kotlinx.coroutines.flow.Flow
import v.sivasubramaniam.calendar.feature_reminder.domain.model.Reminder
import v.sivasubramaniam.calendar.feature_reminder.domain.repository.ReminderRepository
import javax.inject.Inject

class GetReminders @Inject constructor(
    private val repository: ReminderRepository
) {
    operator fun invoke(): Flow<List<Reminder>> {
        return repository.getReminders()
    }
}
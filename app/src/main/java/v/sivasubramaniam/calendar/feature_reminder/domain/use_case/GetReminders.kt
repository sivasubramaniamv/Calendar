package v.sivasubramaniam.calendar.feature_reminder.domain.use_case

import kotlinx.coroutines.flow.Flow
import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderResponse
import v.sivasubramaniam.calendar.feature_reminder.domain.repository.ReminderRepository
import javax.inject.Inject

class GetReminders @Inject constructor(
    private val repository: ReminderRepository
) {
    operator fun invoke(): Flow<List<ReminderResponse>> {
        return repository.getReminders()
    }
}
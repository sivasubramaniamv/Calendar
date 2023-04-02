package v.sivasubramaniam.calendar.feature_reminder.domain.use_case

import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderResponse
import v.sivasubramaniam.calendar.feature_reminder.domain.repository.ReminderRepository
import javax.inject.Inject

class GetReminder @Inject constructor(
    private val repository: ReminderRepository
) {
    suspend operator fun invoke(id: Int): ReminderResponse {
        return repository.getReminder(id)
    }
}
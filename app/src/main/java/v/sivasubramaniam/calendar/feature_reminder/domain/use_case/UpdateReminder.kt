package v.sivasubramaniam.calendar.feature_reminder.domain.use_case

import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderResponse
import v.sivasubramaniam.calendar.feature_reminder.domain.repository.ReminderRepository
import javax.inject.Inject

class UpdateReminder @Inject constructor(
    private val repository: ReminderRepository
) {
    suspend operator fun invoke(reminder: ReminderResponse) {
        repository.updateReminder(reminder)
    }
}
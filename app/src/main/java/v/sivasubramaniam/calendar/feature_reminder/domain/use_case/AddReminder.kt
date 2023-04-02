package v.sivasubramaniam.calendar.feature_reminder.domain.use_case

import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderRequest
import v.sivasubramaniam.calendar.feature_reminder.domain.repository.ReminderRepository
import javax.inject.Inject

class AddReminder @Inject constructor(
    private val repository: ReminderRepository
) {
    suspend operator fun invoke(reminder: ReminderRequest) {
        repository.addReminder(reminder)
    }
}
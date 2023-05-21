package v.sivasubramaniam.calendar.feature_reminder.domain.use_case

import v.sivasubramaniam.calendar.feature_reminder.domain.repository.ReminderRepository
import javax.inject.Inject

class FetchReminders @Inject constructor(
    private val repository: ReminderRepository
) {
    suspend operator fun invoke() {
        repository.fetchReminders()
    }
}
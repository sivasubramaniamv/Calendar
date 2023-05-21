package v.sivasubramaniam.calendar.feature_reminder.domain.use_case

import v.sivasubramaniam.calendar.core.util.SimpleResource
import v.sivasubramaniam.calendar.feature_reminder.domain.model.Reminder
import v.sivasubramaniam.calendar.feature_reminder.domain.repository.ReminderRepository
import javax.inject.Inject

class DeleteReminder @Inject constructor(
    private val repository: ReminderRepository
) {
    suspend operator fun invoke(reminder: Reminder): SimpleResource {
        return repository.deleteReminder(reminder)
    }
}
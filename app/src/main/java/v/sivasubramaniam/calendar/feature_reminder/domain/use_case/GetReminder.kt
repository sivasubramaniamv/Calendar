package v.sivasubramaniam.calendar.feature_reminder.domain.use_case

import v.sivasubramaniam.calendar.core.util.Resource
import v.sivasubramaniam.calendar.feature_reminder.domain.model.Reminder
import v.sivasubramaniam.calendar.feature_reminder.domain.repository.ReminderRepository
import javax.inject.Inject

class GetReminder @Inject constructor(
    private val repository: ReminderRepository
) {
    suspend operator fun invoke(id: String): Resource<Reminder> {
        return repository.getReminder(id)
    }
}
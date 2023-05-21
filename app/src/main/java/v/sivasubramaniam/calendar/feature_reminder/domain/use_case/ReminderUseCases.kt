package v.sivasubramaniam.calendar.feature_reminder.domain.use_case

data class ReminderUseCases(
    val fetchReminders: FetchReminders,
    val addReminder: AddReminder,
    val getReminders: GetReminders,
    val getReminder: GetReminder,
    val updateReminder: UpdateReminder,
    val deleteReminder: DeleteReminder
)
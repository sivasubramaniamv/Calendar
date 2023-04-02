package v.sivasubramaniam.calendar.feature_reminder.presentation

data class ReminderState(
    val title: String = "",
    val year: Int = 2023,
    val month: Int = 2,
    val dayOfMonth: Int = 14,
    val hour: Int = 12,
    val minute: Int = 18,
    val account: String = "sivamani123121@gmail.com",
    val repetition: String = "Does not repeat",

    val showAccountsDialog: Boolean = false,
    val allDay: Boolean = true,
    val showDatePicker: Boolean = false,
    val showTimePicker: Boolean = false,
    val showRepetitionDialog: Boolean = false,
)
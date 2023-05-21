package v.sivasubramaniam.calendar.feature_reminder.presentation

data class ReminderState(
    val title: String = "",
    val year: Int = 0,
    val month: Int = 0,
    val dayOfMonth: Int = 0,
    val dateString: String = "",
    val hour: Int = 0,
    val minute: Int = 0,
    val timeString: String = "",
    val account: String = "sivamani123121@gmail.com",
    val repetition: String = "Does not repeat",

    val showAccountsDialog: Boolean = false,
    val allDay: Boolean = true,
    val showDatePicker: Boolean = false,
    val showTimePicker: Boolean = false,
    val showRepetitionDialog: Boolean = false,
)
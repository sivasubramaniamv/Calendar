package v.sivasubramaniam.calendar.feature_reminder.presentation

data class ReminderState(
    val title: String = "",
    val year: Int = 2023,
    val month: Int = 2,
    val dayOfMonth: Int = 14,
    val hour: Int = 12,
    val minute: Int = 18,
    val repetition: String = "Does not repeat",

    val allDay: Boolean = false,
    val showDatePicker: Boolean = false,
    val showTimePicker: Boolean = false,
    val showRepetition: Boolean = false,
)
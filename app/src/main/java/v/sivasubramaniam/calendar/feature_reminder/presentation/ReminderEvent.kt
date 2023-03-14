package v.sivasubramaniam.calendar.feature_reminder.presentation

sealed class ReminderEvent {

    data class EnteredTitle(val title: String): ReminderEvent()
    data class PickedDate(val year: Int, val month: Int, val dayOfMonth: Int): ReminderEvent()
    data class PickedTime(val hour: Int, val minute: Int): ReminderEvent()
    data class ChoseRepetition(val repetition: String): ReminderEvent()
    object Save: ReminderEvent()

    object ToggleAllDay: ReminderEvent()
    object ToggleDatePicker: ReminderEvent()
    object ToggleTimePicker: ReminderEvent()
    object ToggleRepetition: ReminderEvent()
}
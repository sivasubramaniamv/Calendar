package v.sivasubramaniam.calendar.feature_reminder.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import v.sivasubramaniam.calendar.core.presentation.util.formatDate
import v.sivasubramaniam.calendar.core.presentation.util.time12hour
import v.sivasubramaniam.calendar.feature_reminder.domain.use_case.ReminderUseCases
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.ChoseAccount
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.ChoseRepetition
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.EnteredTitle
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.PickedDate
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.PickedTime
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.Save
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.ToggleAccounts
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.ToggleAllDay
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.ToggleDatePicker
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.ToggleRepetition
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.ToggleTimePicker
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class ReminderViewModel @Inject constructor(
    private val reminderUseCases: ReminderUseCases
): ViewModel() {

    private val _state = mutableStateOf(ReminderState())
    val state: State<ReminderState> = _state

    init {
        val calendar = Calendar.getInstance()

        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
        val hour = calendar[Calendar.HOUR_OF_DAY]

        _state.value = _state.value.copy(
            year = year,
            month = month,
            dayOfMonth = dayOfMonth,
            hour = hour,
            dateString = formatDate(year, month + 1, dayOfMonth),
            timeString = time12hour(hour, 0),
        )

        viewModelScope.launch(
            context = Dispatchers.IO
        ) {
            reminderUseCases.fetchReminders()
            val reminders = reminderUseCases.getReminders()

            reminders.collect {
                it.forEach { reminder ->
                    Log.d("ReminderViewModel", reminder.title)
                }
            }
        }
    }

    fun onEvent(event: ReminderEvent) {
        when(event) {
            is EnteredTitle -> {
                _state.value = _state.value.copy(
                    title = event.title
                )
            }
            is ToggleAccounts -> {
                _state.value = _state.value.copy(
                    showAccountsDialog = !state.value.showAccountsDialog
                )
            }
            is ChoseAccount -> {
                _state.value = _state.value.copy(
                    showAccountsDialog = false,
                    account = event.account
                )
            }
            is ToggleAllDay -> {
                _state.value = _state.value.copy(
                    allDay = !state.value.allDay
                )
            }
            is ToggleDatePicker -> {
                _state.value = _state.value.copy(
                    showDatePicker = !state.value.showDatePicker
                )
            }
            is PickedDate -> {
                _state.value = _state.value.copy(
                    year = event.year,
                    month = event.month,
                    dayOfMonth = event.dayOfMonth,
                    dateString = formatDate(event.year, event.month + 1, event.dayOfMonth)
                )
            }
            is ToggleTimePicker -> {
                _state.value = _state.value.copy(
                    showTimePicker = !state.value.showTimePicker
                )
            }
            is PickedTime -> {
                _state.value = _state.value.copy(
                    hour = event.hour,
                    minute = event.minute,
                    timeString = time12hour(event.hour, event.minute)
                )
            }
            is ToggleRepetition -> {
                _state.value = _state.value.copy(
                    showRepetitionDialog = !state.value.showRepetitionDialog
                )
            }
            is ChoseRepetition -> {
                _state.value = _state.value.copy(
                    showRepetitionDialog = false,
                    repetition = event.repetition
                )
            }
            is Save -> { }
        }
    }
}
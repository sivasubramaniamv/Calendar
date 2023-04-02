package v.sivasubramaniam.calendar.feature_reminder.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import v.sivasubramaniam.calendar.feature_reminder.domain.use_case.ReminderUseCases
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.*
import javax.inject.Inject

@HiltViewModel
class ReminderViewModel @Inject constructor(
    private val reminderUseCases: ReminderUseCases
): ViewModel() {

    private val _state = mutableStateOf(ReminderState())
    val state: State<ReminderState> = _state

    init {
        viewModelScope.launch(
            context = Dispatchers.IO
        ) {
            reminderUseCases.populateReminders()
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
                    dayOfMonth = event.dayOfMonth
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
                    minute = event.minute
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
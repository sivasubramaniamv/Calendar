package v.sivasubramaniam.calendar.feature_reminder.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.*
import javax.inject.Inject

@HiltViewModel
class ReminderViewModel @Inject constructor(
    //private val addReminderUseCase: AddReminderUseCase
): ViewModel() {

    private val _state = mutableStateOf(ReminderState())
    val state: State<ReminderState> = _state

    fun onEvent(event: ReminderEvent) {
        when(event) {
            is EnteredTitle -> {
                _state.value = _state.value.copy(
                    title = event.title
                )
            }
            is PickedDate -> {
                _state.value = _state.value.copy(
                    year = event.year,
                    month = event.month,
                    dayOfMonth = event.dayOfMonth
                )
            }
            is PickedTime -> {
                _state.value = _state.value.copy(
                    hour = event.hour,
                    minute = event.minute
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
            is ToggleTimePicker -> {
                _state.value = _state.value.copy(
                    showTimePicker = !state.value.showTimePicker
                )
            }
            is ToggleRepetition -> {
                _state.value = _state.value.copy(
                    showRepetition = !state.value.showRepetition
                )
            }
            is ChoseRepetition -> {
                _state.value = _state.value.copy(
                    showRepetition = false,
                    repetition = event.repetition
                )
            }
            is Save -> { }
        }
    }
}
package v.sivasubramaniam.calendar.feature_reminder.presentation

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import v.sivasubramaniam.calendar.R
import v.sivasubramaniam.calendar.core.presentation.components.SimpleTextField
import v.sivasubramaniam.calendar.core.presentation.ui.theme.CapeCodDark
import v.sivasubramaniam.calendar.core.presentation.ui.theme.DoveGray
import v.sivasubramaniam.calendar.core.presentation.ui.theme.Pumice
import v.sivasubramaniam.calendar.core.presentation.ui.theme.RiverBed
import v.sivasubramaniam.calendar.core.presentation.ui.theme.Shark
import v.sivasubramaniam.calendar.core.presentation.ui.theme.Silver
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.ChoseAccount
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.ChoseRepetition
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.EnteredTitle
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.PickedDate
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.PickedTime
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.ToggleAccounts
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.ToggleAllDay
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.ToggleRepetition
import v.sivasubramaniam.calendar.feature_reminder.presentation.components.AccountItem
import v.sivasubramaniam.calendar.feature_reminder.presentation.components.RepetitionItem
import java.lang.System.currentTimeMillis

@Composable
fun NewReminderScreen(
    navController: NavController,
    viewModel: ReminderViewModel = hiltViewModel()
) {
    val reminderState = viewModel.state.value
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        delay(200)
        focusRequester.requestFocus()
    }

    val context = LocalContext.current

    val datePicker = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
            viewModel.onEvent(
                PickedDate(selectedYear, selectedMonth, selectedDayOfMonth)
            )
        }, reminderState.year, reminderState.month, reminderState.dayOfMonth
    )

    datePicker.datePicker.minDate = currentTimeMillis() - 1000

    val timePicker = TimePickerDialog(
        context,
        { _, selectedHour: Int, selectedMinute: Int ->
            viewModel.onEvent(
                PickedTime(selectedHour, selectedMinute)
            )
        }, reminderState.hour, reminderState.minute, false
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                modifier = Modifier.statusBarsPadding(),
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close Screen",
                            tint = Pumice
                        )
                    }
                },
                actions = {
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.primary
                        ),
                    ) {
                        Text(
                            text = "Save",
                            color = MaterialTheme.colors.onPrimary,
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.background,
                elevation = 0.dp
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(state = rememberScrollState()),
        ) {
            SimpleTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 60.dp, bottom = 8.dp, end = 16.dp),
                text = reminderState.title,
                placeholder = "Remind me to...",
                style = MaterialTheme.typography.h5,
                onValueChange = {
                    viewModel.onEvent(EnteredTitle(it))
                },
                focusRequester = focusRequester
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                color = CapeCodDark
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { viewModel.onEvent(ToggleAccounts) }
                    .padding(horizontal = 20.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Reminder Account",
                    tint = Pumice
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Reminders"
                    )
                    Text(
                        text = reminderState.account,
                        style = MaterialTheme.typography.caption
                    )
                }
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                color = CapeCodDark
            )
            if (reminderState.showAccountsDialog) {
                val accounts = listOf(
                    "sivamani123121@gmail.com",
                    "patrickbateman@batmail.com",
                    "mustafizurrahman@imail.com",
                    "jakewharton@mmail.com",
                    "dwaynejohnson@dj.com",
                )
                Dialog(
                    onDismissRequest = { viewModel.onEvent(ToggleAccounts) }
                ) {
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(24.dp))
                            .background(Shark)
                            .padding(vertical = 10.dp)
                            .verticalScroll(state = rememberScrollState()),
                    ) {
                        Text(
                            text = "Calendar",
                            modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp),
                            fontSize = MaterialTheme.typography.subtitle1.fontSize,
                            fontWeight = FontWeight.SemiBold
                        )
                        accounts.forEach {
                            AccountItem(
                                text = it,
                                onClick = { viewModel.onEvent(ChoseAccount(it)) }
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }
                    .padding(start = 20.dp, top = 2.dp, end = 8.dp, bottom = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.schedule),
                    contentDescription = "Schedule",
                    tint = Pumice
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "All-day",
                )
                Spacer(modifier = Modifier.weight(1f))
                Switch(
                    checked = reminderState.allDay,
                    onCheckedChange = { viewModel.onEvent(ToggleAllDay) },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colors.primary,
                        checkedTrackColor = RiverBed,
                        checkedTrackAlpha = 1f,
                        uncheckedThumbColor = Silver,
                        uncheckedTrackColor = DoveGray,
                        uncheckedTrackAlpha = 1f
                    )
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { datePicker.show() }
                    .padding(start = 60.dp, top = 10.dp, end = 16.dp, bottom = 10.dp)
            ) {
                Text(
                    text = reminderState.dateString,
                )
                if (!reminderState.allDay) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = reminderState.timeString,
                        modifier = Modifier.clickable { timePicker.show() }
                    )
                }
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                color = CapeCodDark
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { viewModel.onEvent(ToggleRepetition) }
                    .padding(horizontal = 20.dp, vertical = 12.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Event Repetition",
                    tint = Pumice
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = reminderState.repetition,
                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                color = CapeCodDark
            )
            if (reminderState.showRepetitionDialog) {
                val repeatOptions = listOf(
                    "Does not repeat",
                    "Every day",
                    "Every week",
                    "Every month",
                    "Every year",
                    "Custom..."
                )
                Dialog(
                    onDismissRequest = { viewModel.onEvent(ToggleRepetition) }
                ) {
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(24.dp))
                            .background(Shark)
                            .padding(vertical = 10.dp),
                    ) {
                        repeatOptions.forEach {
                            RepetitionItem(
                                text = it,
                                isChosen = reminderState.repetition == it,
                                onClick = { viewModel.onEvent(ChoseRepetition(it)) }
                            )
                        }
                    }
                }
            }
        }
    }
}
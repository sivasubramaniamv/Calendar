package v.sivasubramaniam.calendar.feature_reminder.presentation

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
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
import v.sivasubramaniam.calendar.core.presentation.ui.theme.*
import v.sivasubramaniam.calendar.feature_reminder.presentation.ReminderEvent.*
import v.sivasubramaniam.calendar.feature_reminder.presentation.components.AccountItem
import v.sivasubramaniam.calendar.feature_reminder.presentation.components.RepetitionItem
import java.util.*

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
    val calendar = Calendar.getInstance()

    val year = calendar[Calendar.YEAR]
    val month = calendar[Calendar.MONTH]
    val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]

    val datePicker = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
            viewModel.onEvent(
                PickedDate(selectedYear, selectedMonth, selectedDayOfMonth)
            )
        }, year, month, dayOfMonth
    )

    datePicker.datePicker.minDate = calendar.timeInMillis

    val hourOfDay = calendar[Calendar.HOUR_OF_DAY]
    val minute = calendar[Calendar.MINUTE]

    val timePicker = TimePickerDialog(
        context,
        { _, selectedHour: Int, selectedMinute: Int ->
            viewModel.onEvent(
                PickedTime(selectedHour, selectedMinute)
            )
        }, hourOfDay, minute, false
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
                    text = "${reminderState.dayOfMonth}/${reminderState.month + 1}/${reminderState.year}",
                )
                if (!reminderState.allDay) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "${reminderState.hour}:${reminderState.minute}",
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
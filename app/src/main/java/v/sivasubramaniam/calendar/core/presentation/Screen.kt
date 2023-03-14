package v.sivasubramaniam.calendar.core.presentation

sealed class Screen(val route: String) {
    object EventListScreen: Screen("event_list_screen")
    object NewReminderScreen: Screen("new_reminder_screen")
}
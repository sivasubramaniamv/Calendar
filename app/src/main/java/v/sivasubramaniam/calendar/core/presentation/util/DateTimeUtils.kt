package v.sivasubramaniam.calendar.core.presentation.util

import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

/** Returns date in a readable format.
 * Example: Sat, May 20, 2023
 */
fun formatDate(year: Int, month: Int, dayOfMonth: Int): String {
    val localDate = LocalDate.of(year, month, dayOfMonth)
    val dayOfWeek = "${localDate.dayOfWeek}".take(3).lowercase().replaceFirstChar(Char::titlecase)
    val formattedMonth = "${localDate.month}".take(3).lowercase().replaceFirstChar(Char::titlecase)
    return "$dayOfWeek, $formattedMonth $dayOfMonth, $year"
}

fun time12hour(hour: Int, minute: Int): String {
    val localTime = LocalTime.of(hour, minute)
    return localTime.format(DateTimeFormatter.ofPattern("h:mm a"))
}
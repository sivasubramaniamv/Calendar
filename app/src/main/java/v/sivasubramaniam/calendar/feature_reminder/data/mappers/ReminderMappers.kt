package v.sivasubramaniam.calendar.feature_reminder.data.mappers

import v.sivasubramaniam.calendar.feature_reminder.data.database.entity.ReminderEntity
import v.sivasubramaniam.calendar.feature_reminder.data.remote.dto.ReminderDto
import v.sivasubramaniam.calendar.feature_reminder.domain.model.Reminder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun Reminder.toDto(): ReminderDto {
    return ReminderDto(
        id = id,
        title = title,
        startDateTime = startDateTime.format(DateTimeFormatter.ISO_DATE_TIME),
        repetition = repetition,
        recurrence = recurrence.map { it.toString() },
        isDone = isDone
    )
}

fun Reminder.toEntity(): ReminderEntity {
    return ReminderEntity(
        id = id,
        title = title,
        startDateTime = startDateTime.format(DateTimeFormatter.ISO_DATE_TIME),
        repetition = repetition,
        recurrence = recurrence.map { it.toString() },
        isDone = isDone
    )
}

fun ReminderEntity.toDomain(): Reminder {
    return Reminder(
        id = id,
        title = title,
        startDateTime = LocalDateTime.parse(startDateTime, DateTimeFormatter.ISO_DATE_TIME),
        repetition = repetition,
        recurrence = if (recurrence.isEmpty()) emptyList() else recurrence.map { LocalDateTime.parse(startDateTime, DateTimeFormatter.ISO_DATE_TIME) },
        isDone = isDone
    )
}

fun ReminderDto.toEntity(): ReminderEntity {
    return ReminderEntity(
        id = id,
        title = title,
        startDateTime = startDateTime,
        repetition = repetition,
        recurrence = recurrence,
        isDone = isDone
    )
}
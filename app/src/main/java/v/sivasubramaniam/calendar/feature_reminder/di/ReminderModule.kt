package v.sivasubramaniam.calendar.feature_reminder.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import v.sivasubramaniam.calendar.core.data.database.CalendarDb
import v.sivasubramaniam.calendar.feature_reminder.data.remote.ReminderServiceImpl
import v.sivasubramaniam.calendar.feature_reminder.data.repository.ReminderRepositoryImpl
import v.sivasubramaniam.calendar.feature_reminder.domain.repository.ReminderRepository
import v.sivasubramaniam.calendar.feature_reminder.domain.use_case.*

@Module
@InstallIn(SingletonComponent::class)
object ReminderModule {

    @Provides
    fun provideReminderUseCases(repository: ReminderRepository): ReminderUseCases {
        return ReminderUseCases(
            populateReminders = PopulateReminders(repository),
            addReminder = AddReminder(repository),
            getReminders = GetReminders(repository),
            getReminder = GetReminder(repository),
            updateReminder = UpdateReminder(repository),
            deleteReminder = DeleteReminder(repository)
        )
    }

    @Provides
    fun provideReminderRepository(service: ReminderServiceImpl, database: CalendarDb): ReminderRepository {
        return ReminderRepositoryImpl(service, database)
    }
}
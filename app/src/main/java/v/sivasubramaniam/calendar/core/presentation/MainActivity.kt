package v.sivasubramaniam.calendar.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import v.sivasubramaniam.calendar.core.presentation.ui.theme.CalendarTheme
import v.sivasubramaniam.calendar.feature_home.presentation.EventListScreen
import v.sivasubramaniam.calendar.feature_reminder.presentation.NewReminderScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalendarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.EventListScreen.route
                    ) {
                        composable(
                            route = Screen.EventListScreen.route
                        ) {
                            EventListScreen(navController)
                        }
                        composable(
                            route = Screen.NewReminderScreen.route
                        ) {
                            NewReminderScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
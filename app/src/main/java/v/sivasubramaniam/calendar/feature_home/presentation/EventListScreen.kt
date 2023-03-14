package v.sivasubramaniam.calendar.feature_home.presentation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun EventListScreen(
    navController: NavController
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "New Reminder"
                )
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "March")
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Open Monthly Calendar"
                    )
                },
            )
        }
    ) { padding ->
    }
}
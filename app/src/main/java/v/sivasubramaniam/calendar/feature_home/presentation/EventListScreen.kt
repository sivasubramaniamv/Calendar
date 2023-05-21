package v.sivasubramaniam.calendar.feature_home.presentation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import v.sivasubramaniam.calendar.R
import v.sivasubramaniam.calendar.core.presentation.Screen
import v.sivasubramaniam.calendar.core.presentation.ui.theme.*
import v.sivasubramaniam.calendar.core.util.Constants.ScrimOpacity
import v.sivasubramaniam.calendar.feature_home.presentation.components.*

@Composable
fun EventListScreen(
    navController: NavController
) {
    val scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val coroutineSCope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                backgroundColor = SharkVariant,
                contentPadding = PaddingValues(top = 40.dp, start = 8.dp, end = 16.dp)
            ) {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                    IconButton(onClick = {
                        coroutineSCope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Drawer Menu",
                            tint = Pumice
                        )
                    }
                    Spacer(modifier = Modifier.width(2.dp))
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clickable { },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = "April",
                            fontSize = MaterialTheme.typography.h6.fontSize,
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Open Monthly Calendar",
                            tint = Pumice
                        )
                    }
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Events",
                        tint = Pumice
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.today),
                        contentDescription = "Today",
                        tint = Pumice
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.profile_picture),
                    contentDescription = "Account",
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .clickable { }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.NewReminderScreen.route) },
                modifier = Modifier.navigationBarsPadding(),
                shape = RoundedCornerShape(30),
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = MaterialTheme.colors.onSecondary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "New Reminder"
                )
            }
        },
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Shark)
                    .systemBarsPadding()
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.White,
                                fontSize = MaterialTheme.typography.h6.fontSize,
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = RedHatDisplay
                            )
                        ) {
                            append("Google ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.White,
                                fontSize = MaterialTheme.typography.h6.fontSize,
                                fontWeight = FontWeight.Medium,
                                fontFamily = RedHatDisplay
                            )
                        ) {
                            append("Calendar")
                        }
                    },
                    modifier = Modifier.padding(24.dp)
                )
                IconOption(
                    drawableRes = R.drawable.view_agenda,
                    option = "Schedule",
                    onClick = { }
                )
                IconOption(
                    drawableRes = R.drawable.calendar_view_day,
                    option = "Day",
                    onClick = { }
                )
                IconOption(
                    drawableRes = R.drawable.view_three_days,
                    option = "3 Days",
                    onClick = { }
                )
                IconOption(
                    drawableRes = R.drawable.calendar_view_week,
                    option = "Week",
                    onClick = { }
                )
                IconOption(
                    drawableRes = R.drawable.calendar_view_month,
                    option = "Month",
                    onClick = { }
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    color = CapeCod
                )
                IconOption(
                    drawableRes = R.drawable.refresh,
                    option = "Refresh",
                    onClick = { }
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    color = CapeCod
                )
                EventDisplayChoice(email = "sivamani123121@gmail.com")
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 64.dp, top = 8.dp, bottom = 8.dp),
                    color = CapeCod
                )
                EventDisplayChoice(email = "peyarillai13@gmail.com")
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 64.dp, top = 8.dp, bottom = 8.dp),
                    color = CapeCod
                )
                EventDisplayChoice(email = "sivasubramaniam202@gmail.com")
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 64.dp, top = 8.dp, bottom = 8.dp),
                    color = CapeCod
                )
                ImageOption(text = "local account")
                CheckboxOption(
                    checked = true,
                    text = "local account",
                    color = Boulder,
                    onClick = { }
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 64.dp, top = 8.dp, bottom = 8.dp),
                    color = CapeCod
                )
                CheckboxOption(
                    checked = true,
                    text = "Birthdays",
                    color = AquaForest,
                    onClick = { }
                )
                CheckboxOption(
                    checked = true,
                    text = "Holidays",
                    color = BreakerBay,
                    onClick = { }
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    color = CapeCod
                )
                IconOption(
                    drawableRes = R.drawable.settings,
                    option = "Settings",
                    onClick = { }
                )
                IconOption(
                    drawableRes = R.drawable.help_outline,
                    option = "Help & feedback",
                    onClick = { }
                )
            }
        },
        drawerScrimColor = Color.Black.copy(alpha = ScrimOpacity)
    ) { padding ->
        val events = listOf(
            listOf("Ambedkar Jayanti", "Vaisakhi"),
            listOf("Mesadi/Vaisakhadi"),
            listOf("Jamat Ul-Vida"),
            listOf("Ramzan Id/Eid-ul-Fitar")
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(events){
                EventListItem(day = "Fri", date = "14", events = it)
            }
            items(1) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 64.dp, end = 16.dp)
                ) {
                    ReminderCard(
                        title = "Complete List items (event & reminder)",
                        time = "11:30 AM"
                    )
                }
            }
        }
    }
}
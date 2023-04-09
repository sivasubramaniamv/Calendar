package v.sivasubramaniam.calendar.feature_home.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import v.sivasubramaniam.calendar.R
import v.sivasubramaniam.calendar.core.presentation.ui.theme.HavelockBlue
import v.sivasubramaniam.calendar.core.presentation.ui.theme.MineShaft

@Composable
fun ReminderCard( // TODO: add param reminder: ReminderResponse
    title: String,
    time: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = HavelockBlue,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 7.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.pan_tool_alt),
                    contentDescription = "Reminder Icon",
                    modifier = Modifier.size(18.dp),
                    tint = MineShaft
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = title,
                    color = MineShaft,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
            Text(
                text = time,
                modifier = Modifier.padding(start = 2.dp),
                color = MineShaft,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}
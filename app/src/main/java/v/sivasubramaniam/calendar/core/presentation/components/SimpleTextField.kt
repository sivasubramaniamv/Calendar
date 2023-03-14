package v.sivasubramaniam.calendar.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import v.sivasubramaniam.calendar.core.presentation.ui.theme.Pumice

@Composable
fun SimpleTextField(
    modifier: Modifier = Modifier,
    text: String,
    placeholder: String = "",
    error: String = "",
    style: TextStyle = TextStyle(),
    backgroundColor: Color = MaterialTheme.colors.surface,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    onValueChange: (String) -> Unit,
    focusRequester: FocusRequester = FocusRequester()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor)
                .focusRequester(focusRequester),
            textStyle = style,
            singleLine = singleLine,
            maxLines = maxLines,
            cursorBrush = SolidColor(Pumice),
            decorationBox = { innerTextField ->
                if (text.isEmpty()) {
                    Text(
                        text = placeholder,
                        color = Pumice,
                        style = style
                    )
                }
                innerTextField()
            },
        )
    }
}
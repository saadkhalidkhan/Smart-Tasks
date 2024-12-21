package com.droidgeeks.coreui.ui.reusable.fields

import android.content.res.Configuration
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidgeeks.coreui.ui.theme.CellStroke
import com.droidgeeks.coreui.ui.theme.SmartTasksAppTheme

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    searchText: String = "",
    maxLines: Int = 1,
    cornerShape: RoundedCornerShape = RoundedCornerShape(8.dp),
    singleLine: Boolean = true,
    leadingIcon: ImageVector = Icons.Filled.Search,
    focusedBorderColor: Color = CellStroke.copy(alpha = 0.2f),
    unFocusedBorderColor: Color = CellStroke.copy(alpha = 0.2f),
    leadingIconColor: Color = Color.White,
    textColor: Color = Color.White,
    cursorColor: Color = Color.White,
    onSearchValueChange: (parameter: String) -> Unit = {},
    onSearchAction: (searchedLocation: String) -> Unit = {},
) {
    OutlinedTextField(
        value = searchText,
        onValueChange = {
            onSearchValueChange(it)
        },
        placeholder = {
            Text(
                text = searchText,
                color = textColor,
                modifier = Modifier
            )
        },
        label = { Text("Search", color = Color.White) },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = { onSearchAction(searchText) }),
        shape = cornerShape,
        leadingIcon = { Icon(imageVector = leadingIcon, contentDescription = "Search Icon") },
        modifier = modifier,
        singleLine = singleLine,
        maxLines = maxLines,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = focusedBorderColor,
            unfocusedBorderColor = unFocusedBorderColor,
            cursorColor = cursorColor,
            leadingIconColor = leadingIconColor,
            textColor = textColor,
            backgroundColor = focusedBorderColor
        )

    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SearchFieldPreview() {
    SmartTasksAppTheme {
        SearchField()
    }
}
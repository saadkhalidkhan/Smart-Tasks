package com.droidgeeks.coreui.ui.reusable

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidgeeks.coreui.R
import com.droidgeeks.coreui.ui.theme.SmartTasksAppTheme

@Composable
fun TasksAppBar(
    title: String? = null,
    showBackIcon: Boolean = true,
    showForwardIcon: Boolean = true,
    onNavBackClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (showBackIcon) {
            IconButton(
                modifier = Modifier
                    .size(32.dp)
                    .padding(6.dp),
                onClick = onNavBackClick,
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(
                        id = R.drawable.coreui_back
                    ),
                    contentDescription = "Nav back",
                    tint = Color(0xFF000000)
                )
            }
        }
        if (title != null) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                text = title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h2.copy(color = Color(0xFF000000)),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        }
        if (showForwardIcon) {
            IconButton(
                modifier = Modifier
                    .size(32.dp)
                    .padding(6.dp),
                onClick = onNavBackClick,
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(
                        id = R.drawable.coreui_forward
                    ),
                    contentDescription = "Nav back",
                    tint = Color(0xFF000000)
                )
            }
        }

    }

}

@Preview
@Composable
private fun AppBarPreview() {
    SmartTasksAppTheme {
        TasksAppBar(
            title = "Title",
            showBackIcon = true,
            onNavBackClick = {},
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AppBarDarkPreview() {
    SmartTasksAppTheme {
        TasksAppBar(
            title = "Title",
            showBackIcon = true,
            onNavBackClick = {},
        )
    }
}

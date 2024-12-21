package com.droidgeeks.coreui.ui.reusable.images

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.droidgeeks.coreui.R
import com.droidgeeks.coreui.ui.theme.SmartTasksAppTheme

@Composable
fun CircularImageWithPlaceHolder(
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    url: String?,
    contentDescription: String? = null,
    placeholder: Painter = painterResource(id = R.drawable.coreui_profile_placeholder)
) {

    AsyncImage(
        modifier = modifier.clip(CircleShape),
        model = url,
        contentDescription = contentDescription,
        contentScale = contentScale,
        placeholder = placeholder,
        error = placeholder,
    )
}

@Preview
@Composable
private fun PreviewItemCard() {
    SmartTasksAppTheme {
        CircularImageWithPlaceHolder(url = "")
    }
}

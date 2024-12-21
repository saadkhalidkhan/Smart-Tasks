package com.droidgeeks.smarttasks.presentation.home.entity

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidgeeks.coreui.ui.reusable.images.CircularImageWithPlaceHolder
import com.droidgeeks.coreui.ui.theme.SmartTasksAppTheme
import com.droidgeeks.smarttask.R
import com.droidgeeks.smarttasks.domain.model.TasksResponseModel

@Composable
fun TasksItem(
    modifier: Modifier = Modifier,
    task: TasksResponseModel = TasksResponseModel(),
    onClickItem: (TasksResponseModel) -> Unit = {},
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClickItem(task)
            },
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(
            width = 1.dp,
            color = Color(0xFFFFFFFF),
        ),
        backgroundColor = Color(0xFFFFFFFF),
        elevation = 0.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(8.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,) {
                Text(
                    text = "View Type",
                    style = MaterialTheme.typography.caption.copy(color = Color(0xFF4E504E)),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_right_arrow),
                    contentDescription = "Icon",
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = task.userViewType.orEmpty(),
                    style = MaterialTheme.typography.h3.copy(color = Color(0xFF000000)),
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = task.type.orEmpty(),
                    style = MaterialTheme.typography.h3.copy(color = Color(0xFF4CAF50)),
                )

            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                modifier = Modifier.height(1.dp),
                color = Color(0xFFFFDE61),
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                CircularImageWithPlaceHolder(
                    modifier = Modifier.size(60.dp),
                    url = task.avatarUrl,
                    placeholder = painterResource(id = com.droidgeeks.coreui.R.drawable.coreui_profile_placeholder),
                )
                Spacer(modifier = Modifier.width(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = task.login.orEmpty(),
                        style = MaterialTheme.typography.h3.copy(color = Color(0xFF000000)),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier.size(14.dp),
                            painter = painterResource(id = R.drawable.ic_marker),
                            contentDescription = "Icon",
                            tint = Color(0xFF000000)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = task.htmlUrl.orEmpty(),
                            style = MaterialTheme.typography.caption.copy(color = Color(0xFF494B49)),
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                            textDecoration = TextDecoration.Underline
                        )
                    }
                }

                Box(modifier = Modifier.fillMaxHeight()) {

                    Icon(
                        modifier = Modifier
                            .size(14.dp)
                            .align(Alignment.CenterEnd),
                        painter = painterResource(id = com.droidgeeks.coreui.R.drawable.coreui_forward),
                        contentDescription = "Click",
                        tint = Color(0xFF000000)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun TasksItemPreview() {
    SmartTasksAppTheme {
        TasksItem(
            task = TasksResponseModel(
                login = "Saad Khan",
                type = "User",
                avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
                htmlUrl = "https://github.com/mojombo",
                userViewType = "public"
            )
        )
    }
}
package com.droidgeeks.smarttasks.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.droidgeeks.coreui.ui.reusable.TasksAppBar
import com.droidgeeks.coreui.ui.reusable.images.CircularImageWithPlaceHolder
import com.droidgeeks.coreui.ui.theme.SmartTasksAppTheme
import com.droidgeeks.smarttask.R
import com.droidgeeks.smarttasks.domain.model.TasksResponseModel
import com.droidgeeks.smarttasks.domain.model.fakeTask
import com.droidgeeks.smarttasks.presentation.home.entity.HomeScreenState

@Composable
fun DetailScreen(
    taskId: String? = "",
    onBackPressed: () -> Unit = {},
    viewModel: DetailViewModel = hiltViewModel()
) {

    val smartTasks by viewModel.tasks.collectAsStateWithLifecycle()
    val isLoading by viewModel.detailScreenState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = Unit) {
        viewModel.getSmartSingleTask(taskId)
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading == HomeScreenState.Loading) {
            CircularProgressIndicator(modifier = Modifier.size(50.dp))
        } else {
            DetailScreenContent(smartTasks ?: fakeTask(), onBackPressed = onBackPressed)
        }

    }

}

@Composable
fun DetailScreenContent(
    task: TasksResponseModel = TasksResponseModel(),
    onBackPressed: () -> Unit = {},
) {
    SmartTasksAppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            TasksAppBar(
                onNavBackClick = onBackPressed,
                title = stringResource(R.string.task_detail),
                showForwardIcon = false
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.fillMaxWidth()) {

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter),
                    contentScale = ContentScale.FillWidth,
                    painter = painterResource(id = R.drawable.task_details),
                    contentDescription = "intro",
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Spacer(modifier = Modifier.height(32.dp))
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
                                text = task.name.orEmpty(),
                                style = MaterialTheme.typography.h3.copy(color = Color(0xFF000000)),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    modifier = Modifier.size(14.dp),
                                    painter = painterResource(id = R.drawable.ic_calender_icon),
                                    contentDescription = "Icon",
                                    tint = Color(0xFF000000)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = task.company.orEmpty(),
                                    style = MaterialTheme.typography.caption.copy(color = Color(0xFF494B49)),
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1,
                                    textDecoration = TextDecoration.None
                                )
                            }
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
                                    text = task.location.orEmpty(),
                                    style = MaterialTheme.typography.caption.copy(color = Color(0xFF494B49)),
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1,
                                    textDecoration = TextDecoration.Underline
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Divider(
                                modifier = Modifier.height(1.dp),
                                color = Color(0xFFFFDE61),
                            )
                            Spacer(modifier = Modifier.height(16.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    modifier = Modifier.weight(1f),
                                    style = MaterialTheme.typography.h3.copy(textAlign = TextAlign.Center),
                                    text = stringResource(R.string.followers),
                                    maxLines = 1,
                                    color = Color(0xFF3D3738),
                                )
                                Text(
                                    modifier = Modifier.weight(1f),
                                    style = MaterialTheme.typography.h3,
                                    textAlign = TextAlign.Center,
                                    maxLines = 1,
                                    text = stringResource(R.string.following),
                                    color = Color(0xFF3D3738),
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    modifier = Modifier.weight(1f),
                                    style = MaterialTheme.typography.h2.copy(textAlign = TextAlign.Center),
                                    color = Color(0xFFEF4B5E),
                                    text = task.followers.toString(),
                                    maxLines = 1,
                                )
                                Text(
                                    modifier = Modifier.weight(1f),
                                    style = MaterialTheme.typography.h2,
                                    color = Color(0xFFEF4B5E),
                                    textAlign = TextAlign.Center,
                                    maxLines = 1,
                                    text = task.following.toString()
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Button(
                    modifier = Modifier
                        .weight(1f)
                        .height(42.dp),
                    enabled = true,
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF009688),
                        contentColor = Color.White,
                        disabledContainerColor = Color(0xFFACACAC)
                    )
                ) {
                    Text(text = stringResource(R.string.resolve), color = Color(0xFFFFFFFF))
                }
                Spacer(Modifier.width(8.dp))
                Button(
                    modifier = Modifier
                        .weight(1f)
                        .height(42.dp),
                    enabled = true,
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF44336),
                        contentColor = Color.White,
                        disabledContainerColor = Color(0xFFACACAC)
                    )
                ) {
                    Text(text = stringResource(R.string.can_t_resolve), color = Color(0xFFFFFFFF))
                }
            }


        }
    }

}


@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    SmartTasksAppTheme {
        DetailScreenContent(
            task = TasksResponseModel(
                login = "Saad Khan",
                type = "User",
                avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
                htmlUrl = "https://github.com/mojombo",
                location = "San Francisco, CA",
                name = "Saad Khan",
                company = "Lambda",
                followers = 62,
                following = 12
            )
        )
    }
}
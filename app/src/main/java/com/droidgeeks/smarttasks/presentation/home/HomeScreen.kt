package com.droidgeeks.smarttasks.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.droidgeeks.coreui.ui.reusable.TasksAppBar
import com.droidgeeks.coreui.ui.reusable.fields.SearchField
import com.droidgeeks.coreui.ui.theme.SmartTasksAppTheme
import com.droidgeeks.smarttask.R
import com.droidgeeks.smarttasks.domain.model.TasksResponseModel
import com.droidgeeks.smarttasks.presentation.home.entity.HomeScreenState
import com.droidgeeks.smarttasks.presentation.home.entity.TasksItem
import com.droidgeeks.smarttasks.presentation.home.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onClickItem: (TasksResponseModel) -> Unit = {}
) {

    val smartTasks by viewModel.tasks.collectAsStateWithLifecycle()
    var searchText by remember { mutableStateOf("") }
    val isLoading by viewModel.homeState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = Unit) {
        viewModel.getSmartTasks()
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading == HomeScreenState.Loading) {
            CircularProgressIndicator(modifier = Modifier.size(50.dp))
        } else {
            HomeScreenContent(searchText, smartTasks, onClickItem, onSearchValueChange = {
                searchText = it
                viewModel.searchAppointments(it)
            })
        }

    }

}

@Composable
fun HomeScreenContent(
    searchText: String,
    smartTasks: List<TasksResponseModel>? = listOf(),
    onClickItem: (TasksResponseModel) -> Unit = {},
    onSearchValueChange: (parameter: String) -> Unit = {}
) {
    val state = rememberLazyListState()
    SmartTasksAppTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            TasksAppBar(title = stringResource(R.string.today))

            if (smartTasks.isNullOrEmpty()  && searchText.isEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier.size(250.dp),
                        painter = painterResource(id = R.drawable.empty_screen),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        style = MaterialTheme.typography.h1.copy(color = Color(0xFF000000)),
                        text = stringResource(R.string.no_tasks_for_today)
                    )
                }
            } else {
                Spacer(modifier = Modifier.height(16.dp))
                SearchField(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                    searchText = searchText,
                    onSearchValueChange = onSearchValueChange
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp),
                    state = state,
                    content = {

                        smartTasks?.let {
                            items(it.size) { index ->
                                TasksItem(
                                    modifier = Modifier.fillMaxWidth(),
                                    task = smartTasks[index],
                                    onClickItem = onClickItem
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }

                    })
            }

        }
    }

}

@Preview
@Composable
fun HomeScreenEmptyContentPreview() {
    SmartTasksAppTheme {
        HomeScreenContent("")
    }
}

@Preview
@Composable
fun HomeScreenContentPreview() {
    SmartTasksAppTheme {
        HomeScreenContent("")
    }
}
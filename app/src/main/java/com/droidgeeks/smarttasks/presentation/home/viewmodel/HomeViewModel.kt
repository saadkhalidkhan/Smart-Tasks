package com.droidgeeks.smarttasks.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidgeeks.smarttasks.data.datasource.remote.api.SmartTasksRemoteDataSource
import com.droidgeeks.smarttasks.data.datasource.remote.api.tasks_api.SmartTasksApi
import com.droidgeeks.smarttasks.domain.model.TasksResponseModel
import com.droidgeeks.smarttasks.domain.model.fakeTask
import com.droidgeeks.smarttasks.presentation.home.entity.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val smartTasksRemoteDataSource: SmartTasksRemoteDataSource,
    private val api: SmartTasksApi
) : ViewModel() {

    private val _homeScreenState = MutableStateFlow<HomeScreenState>(HomeScreenState.Initial)
    val homeState = _homeScreenState.asStateFlow()

    private val _tasks = MutableStateFlow<List<TasksResponseModel>?>(null)
    val tasks = _tasks.asStateFlow()

    private var localTasks: List<TasksResponseModel>? = listOf()

    private var searchJob: Job? = null

    fun getSmartTasks() {
//        viewModelScope.launch {
//            _homeScreenState.value = HomeScreenState.Loading
//            _tasks.value = smartTasksRemoteDataSource.getTasksData()
//        }

        _homeScreenState.value = HomeScreenState.Loading
        api.tasksData(1, 30).enqueue(object : Callback<List<TasksResponseModel>> {
            override fun onResponse(
                call: Call<List<TasksResponseModel>>,
                response: Response<List<TasksResponseModel>>
            ) {
                if (response.isSuccessful) {
                    val users = response.body()
                    // Use the users list (e.g., update the UI)
                    users?.forEach {
                        // For example, show the user login names
                        println(it.login)
                    }
                    _tasks.value = users
                    localTasks = users
                    _homeScreenState.value = HomeScreenState.Success("Success")
                } else {
                    _homeScreenState.value = HomeScreenState.Success("Error")
                }
            }

            override fun onFailure(call: Call<List<TasksResponseModel>>, t: Throwable) {
                // Handle failure
                _homeScreenState.value = HomeScreenState.Success("Error")
            }
        })

    }

    fun searchAppointments(searchText: String) {
        if(searchText.isEmpty()){
            _tasks.value = localTasks
        } else {
            searchJob?.cancel()
            searchJob = viewModelScope.launch {
                delay(300)
                val filteredList = localTasks?.filter {
                    it.login?.contains(searchText, ignoreCase = true) == true
                }
                _tasks.value = filteredList
            }
        }
    }

    fun fakeTasksList(): List<TasksResponseModel> {
        return MutableList(6) {
            fakeTask()
        }.apply {
            for (i in 2..5) {
                add(
                    i, fakeTask().copy(
                        id = i.toLong(),
                        login = "Task $i"
                    )
                )
            }
        }
    }

}
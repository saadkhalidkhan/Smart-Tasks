package com.droidgeeks.smarttasks.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidgeeks.smarttasks.data.datasource.remote.api.SmartTasksRemoteDataSource
import com.droidgeeks.smarttasks.data.datasource.remote.api.tasks_api.SmartTasksApi
import com.droidgeeks.smarttasks.domain.model.TasksResponseModel
import com.droidgeeks.smarttasks.presentation.home.entity.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val smartTasksRemoteDataSource: SmartTasksRemoteDataSource,
    private val api: SmartTasksApi
) : ViewModel() {

    private val _detailScreenState = MutableStateFlow<HomeScreenState>(HomeScreenState.Initial)
    val detailScreenState = _detailScreenState.asStateFlow()

    private val _tasks = MutableStateFlow<TasksResponseModel?>(null)
    val tasks = _tasks.asStateFlow()

    fun getSmartSingleTask(taskId: String?) {

//        viewModelScope.launch {
//            _detailScreenState.value = HomeScreenState.Loading
//            _tasks.value = smartTasksRemoteDataSource.getSingleTasksData(taskId)
//        }

            _detailScreenState.value = HomeScreenState.Loading
            api.singleTasksData(taskId ?: "").enqueue(object :
                Callback<TasksResponseModel> {
                override fun onResponse(call: Call<TasksResponseModel>, response: Response<TasksResponseModel>) {
                    if (response.isSuccessful) {
                        val userDetail = response.body()
                        // Use the userDetail (e.g., update the UI)
                        println("User Name: ${userDetail?.name}")
                        println("User Bio: ${userDetail?.bio}")
                        _detailScreenState.value = HomeScreenState.Success("Success")
                        _tasks.value = userDetail
                    } else {
                        _detailScreenState.value = HomeScreenState.Success("Error")
                    }
                }

                override fun onFailure(call: Call<TasksResponseModel>, t: Throwable) {
                    // Handle failure
                    _detailScreenState.value = HomeScreenState.Success("Error")
                }
            })

    }

    private fun fakeTask(): TasksResponseModel {
        return TasksResponseModel(
            login = "Saad Khan",
            type = "User",
            avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
            htmlUrl = "https://github.com/mojombo",
            userViewType = "public"
        )
    }

}
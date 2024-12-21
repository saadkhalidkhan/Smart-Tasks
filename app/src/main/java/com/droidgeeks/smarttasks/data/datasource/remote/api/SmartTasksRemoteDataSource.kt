package com.droidgeeks.smarttasks.data.datasource.remote.api

import com.droidgeeks.smarttasks.data.datasource.remote.api.tasks_api.SmartTasksApi
import javax.inject.Inject

class SmartTasksRemoteDataSource @Inject constructor(private val api: SmartTasksApi) {

    suspend fun getTasksData() = api.tasksData(1,30)
    suspend fun getSingleTasksData(userId: String) = api.singleTasksData(userId)
}
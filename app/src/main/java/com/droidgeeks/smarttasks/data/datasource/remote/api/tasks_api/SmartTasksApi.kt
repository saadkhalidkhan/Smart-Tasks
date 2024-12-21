package com.droidgeeks.smarttasks.data.datasource.remote.api.tasks_api

import com.droidgeeks.smarttasks.domain.model.TasksResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SmartTasksApi {

//    @GET("users")
//    fun tasksData(
//        @Query("page") page: Int,
//        @Query("per_page") perPage: Int
//    ): Call<List<TasksResponseModel>>
//
//    @GET("users/{userId}")
//    fun singleTasksData(@Path("userId") userId: String): Call<TasksResponseModel>

    @GET("users")
    fun tasksData(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<List<TasksResponseModel>>

    @GET("users/{userId}")
    fun singleTasksData(@Path("userId") userId: String): Call<TasksResponseModel>

}
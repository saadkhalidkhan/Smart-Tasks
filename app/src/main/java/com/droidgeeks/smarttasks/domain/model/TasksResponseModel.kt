package com.droidgeeks.smarttasks.domain.model

import com.google.gson.annotations.SerializedName

data class TasksResponseModel(
    @SerializedName("id") val id: Long? = 0,
    @SerializedName("login") val login: String? = "",
    @SerializedName("node_id") val nodeId: String? = "",
    @SerializedName("avatar_url") val avatarUrl: String? = "",
    @SerializedName("gravatar_id") val gravatarId: String? = "",
    @SerializedName("url") val url: String? = "",
    @SerializedName("html_url") val htmlUrl: String? = "",
    @SerializedName("followers_url") val followersUrl: String? = "",
    @SerializedName("following_url") val followingUrl: String? = "",
    @SerializedName("gists_url") val gistsUrl: String? = "",
    @SerializedName("starred_url") val starredUrl: String? = "",
    @SerializedName("subscriptions_url") val subscriptionsUrl: String? = "",
    @SerializedName("organizations_url") val organizationsUrl: String? = "",
    @SerializedName("repos_url") val reposUrl: String? = "",
    @SerializedName("events_url") val eventsUrl: String? = "",
    @SerializedName("received_events_url") val receivedEventsUrl: String? = "",
    @SerializedName("type") val type: String? = "",
    @SerializedName("user_view_type") val userViewType: String? = "",
    @SerializedName("site_admin") val siteAdmin: Boolean? = false,
    @SerializedName("score") val score: Float? = 0f,
    @SerializedName("name") val name: String? = "",
    @SerializedName("company") val company: String? = "",
    @SerializedName("blog") val blog: String? = "",
    @SerializedName("location") val location: String? = "",
    @SerializedName("email") val email: String? = "",
    @SerializedName("hireable") val hireAble: String? = "",
    @SerializedName("bio") val bio: String? = "",
    @SerializedName("public_repos") val publicRepos: Int? = 0,
    @SerializedName("public_gists") val publicGists: Int? = 0,
    @SerializedName("followers") val followers: Int? = 0,
    @SerializedName("following") val following: Int? = 0,
    @SerializedName("created_at") val createdAt: String? = "",
    @SerializedName("updated_at") val updatedAt: String? = ""
)

fun fakeTask(): TasksResponseModel {
    return TasksResponseModel(
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
}
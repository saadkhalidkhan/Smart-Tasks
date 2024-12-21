package com.droidgeeks.smarttasks.presentation.home.entity

sealed interface HomeScreenState {
    data object Initial : HomeScreenState
    data class Success(val string: String?) : HomeScreenState
    data class Error(val errorMessage: String?) : HomeScreenState

    data object Loading : HomeScreenState
}
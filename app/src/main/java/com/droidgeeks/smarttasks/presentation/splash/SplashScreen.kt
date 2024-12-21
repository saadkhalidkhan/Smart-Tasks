package com.droidgeeks.smarttasks.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidgeeks.coreui.ui.theme.SmartTasksAppTheme
import com.droidgeeks.smarttask.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onGetStarted: () -> Unit = {}) {
    LaunchedEffect(Unit) {
        delay(2000) // Show for 2 seconds
        onGetStarted()
    }
    SplashScreenContent()

}

@Composable
fun SplashScreenContent(
) {
    SmartTasksAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Image(
                modifier = Modifier
                    .align(Alignment.Center),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "intro",
            )

            Image(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 32.dp),
                painter = painterResource(id = R.drawable.intro_illustration),
                contentDescription = "intro",
            )
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SmartTasksAppTheme {
        SplashScreenContent()
    }
}
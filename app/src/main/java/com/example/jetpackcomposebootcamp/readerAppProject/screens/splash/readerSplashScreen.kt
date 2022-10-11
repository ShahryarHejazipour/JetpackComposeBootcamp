package com.example.jetpackcomposebootcamp.readerAppProject.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcomposebootcamp.readerAppProject.components.ReaderLogo
import com.example.jetpackcomposebootcamp.readerAppProject.navigation.ReaderScreens
import kotlinx.coroutines.delay


@Composable
fun ReaderSplashScreen(navController: NavController) {

    /*
    For creating the splash screen that means the a LOGO start and after a few seconds it Gone, we need to Use an
    Compose Animation.
    For using a Compose animation we have to use  "LaunchedEffect" block code.
     */
    val scaleState = remember{
        androidx.compose.animation.core.Animatable(initialValue = 0f)
    }
  LaunchedEffect(key1 = true){
      scaleState.animateTo(targetValue = 0.9f, animationSpec = tween(900,
          easing = {
              OvershootInterpolator(8f).getInterpolation(it)

      }))
      delay(2000L)
      //TODO() : check if there is a FB user, if so take them into the home screen, otherwise, to Login screen.
      navController.navigate(ReaderScreens.LoginScreen.name)

  }



    /*
    Creating LOGO for splash screen: All things that in the splash screen ui called LOGO.
     */
    Surface(modifier = androidx.compose.ui.Modifier
        .padding(15.dp)
        .size(330.dp)
        .scale(scale = scaleState.value),//For adding animation to the splash screen
        shape = CircleShape,
        border= BorderStroke(width = 2.dp, color = Color.LightGray)
    ) {
        Column(
            modifier = androidx.compose.ui.Modifier.padding(1.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ReaderLogo()
            Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))
            Text(text = "\"Read. Change . Yourself\"", style = MaterialTheme.typography.h5, color = Color.LightGray)

        }

    }

}


package com.example.jetpackcomposebootcamp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebootcamp.tipProject.MainContent
import com.example.jetpackcomposebootcamp.tipProject.MyAppTip
import com.example.jetpackcomposebootcamp.tipProject.components.InputField
import com.example.jetpackcomposebootcamp.tipProject.utils.calculateTotalPerPerson
import com.example.jetpackcomposebootcamp.tipProject.utils.calculateTotalTip
import com.example.jetpackcomposebootcamp.tipProject.widgets.RoundIconButton
import com.example.jetpackcomposebootcamp.tipProject.widgets.TopHeader
import com.example.jetpackcomposebootcamp.ui.theme.JetPackComposeBootcampTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeBootcampTheme {
              //  MyApp() // Its belongs to stateIntro Lesson
                MyAppTip {

                   MainContent()
                }
            }
        }
    }
}








//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeBootcampTheme {
        MyAppTip {
            Text(text = "Hello Android!!!")
        }
    }
}

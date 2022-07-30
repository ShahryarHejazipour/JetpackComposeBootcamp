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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar

import androidx.compose.material.Surface
import androidx.compose.material.Text

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebootcamp.tipProject.components.InputField

import com.example.jetpackcomposebootcamp.ui.theme.JetPackComposeBootcampTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeBootcampTheme {
              //  MyApp() // Its belongs to stateIntro Lesson
                MyAppTip {
                   // TopHeader()
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MyAppTip(content: @Composable () -> Unit) {

    JetPackComposeBootcampTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}


//@Preview
@Composable
fun TopHeader(totalPerPerson:Double=134.0) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .clip(
            shape = CircleShape.copy(all = CornerSize(12.dp))
        ), color = Color(color = 0xFFE9D7F7 )
        //.clip(shape = RoundedCornerShape(corner = CornerSize(12.dp)))
    ) {
        Column(modifier = Modifier.padding(12.dp),verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            val total = "%.2f".format(totalPerPerson)
            Text(text = "Total Per Person",
            style = MaterialTheme.typography.h5
            )
            Text(text = "$$total", style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.ExtraBold)
        }
    }

}


@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun MainContent() {

    BillForm(){ billAmt ->
        Log.d("AMT", "MainContent: $billAmt")


    }


}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BillForm(modifier: Modifier = Modifier,
             onValChange:(String)-> Unit = {}) {



    //this state is for Checking VALUE of the something that enter in this TextField
    val totalBillState = remember{
        mutableStateOf("")
    }

    /*
    this state is for validation the something(in this case totalBillState state) that enter in this TextField
     */
    val validState = remember(totalBillState.value){

        totalBillState.value.trim().isNotEmpty()

    }

    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(modifier = Modifier
        .padding(2.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(6.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
            InputField(
                valueState = totalBillState ,
                labelId = "Enter Bill",
                enabled = true ,
                isSingleLine = true,
                onAction = KeyboardActions{
                    if (!validState) return@KeyboardActions

                    onValChange(totalBillState.value.trim())

                    keyboardController?.hide()
                })
            if (validState){

                Row(modifier = Modifier.padding(3.dp), horizontalArrangement = Arrangement.Start) {
                    Text(text = "Split",
                    modifier = Modifier.align(
                        alignment = Alignment.CenterVertically
                    ))
                    
                    Spacer(modifier = Modifier.width(120.dp))

                    Row(modifier = Modifier.padding(horizontal = 3.dp),
                    horizontalArrangement = Arrangement.End) {

                    }
                    
                }
                
            }else{
                
                Box {
                    Text(text = "Not Valid")
                    
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
            Text(text = "Hello Maryam!!!")
        }
    }
}

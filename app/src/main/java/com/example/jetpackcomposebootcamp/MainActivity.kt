package com.example.jetpackcomposebootcamp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebootcamp.movieAppProject.navigation.MovieNavigation
import com.example.jetpackcomposebootcamp.ui.theme.JetPackComposeBootcampTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeBootcampTheme {

             /*   *//*
                Its belongs to stateIntro Lesson
                 *//*
                MyApp() */

                //-------------------------------------------------------------//

                /*
                Its belongs to Tip Project
                 */
/*
                MyAppTip {

                   MainContent()
                }*/

                MyAppMovie {

                   MovieNavigation()

                }
            }
        }
    }
}

@Composable
fun MyAppMovie(content : @Composable () -> Unit) {
    content()
}


//LazyColumn Item's View
@Composable
fun MovieRow(movie:String,onItemClick:(String)->Unit = {}) {
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .clickable { onItemClick(movie) }
        .height(130.dp),
    shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    elevation = 6.dp) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
            shape = RectangleShape,
            elevation = 4.dp) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie Image")

            }
            Text(text = movie)
        }

    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeBootcampTheme {

        //MyApp()
       /* MyAppTip {
            Text(text = "Hello Android!!!")
        }*/

        MyAppMovie {
            MovieNavigation()
        }
    }
}

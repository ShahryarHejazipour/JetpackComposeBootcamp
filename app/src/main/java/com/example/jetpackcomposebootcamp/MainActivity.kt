package com.example.jetpackcomposebootcamp

import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcomposebootcamp.movieAppProject.MyAppMovie
import com.example.jetpackcomposebootcamp.movieAppProject.model.Movie
import com.example.jetpackcomposebootcamp.movieAppProject.navigation.MovieNavigation
import com.example.jetpackcomposebootcamp.noteAppProject.NotesApp
import com.example.jetpackcomposebootcamp.noteAppProject.data.NoteDataSource
import com.example.jetpackcomposebootcamp.noteAppProject.screen.NoteScreen
import com.example.jetpackcomposebootcamp.noteAppProject.screen.NoteViewModel
import com.example.jetpackcomposebootcamp.readerAppProject.ReaderApp
import com.example.jetpackcomposebootcamp.triviaProject.components.Questions
import com.example.jetpackcomposebootcamp.triviaProject.screens.QuestionViewModel
import com.example.jetpackcomposebootcamp.triviaProject.screens.TriviaHome
import com.example.jetpackcomposebootcamp.ui.theme.JetPackComposeBootcampTheme
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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
                //---------------------------------------------------------------//
                /*
                Its belongs to Movie Project
                 */
              /*  MyAppMovie {

                   MovieNavigation()

                }*/
/*
                Surface(color = MaterialTheme.colors.background) {

                    val noteViewModel:NoteViewModel by viewModels()

                    NotesApp(noteViewModel = noteViewModel)

                }*/

                //------------------------------------------------------------------//

                /*
               Its belongs to Trivia Project
                */

           /*     Surface(color = MaterialTheme.colors.background) {

                    TriviaHome()

                }*/
                //------------------------------------------------------------------//
                /*
              Its belongs to AReader Project
               */
                ReaderApp()

            }
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
/*
        MyAppMovie {
            MovieNavigation()
        }*/

        ReaderApp()
    }
}

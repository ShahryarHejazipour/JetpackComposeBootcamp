package com.example.jetpackcomposebootcamp.noteAppProject

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.jetpackcomposebootcamp.noteAppProject.screen.NoteScreen
import com.example.jetpackcomposebootcamp.noteAppProject.screen.NoteViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesApp(noteViewModel: NoteViewModel) {
    val notesList = noteViewModel.noteList.collectAsState().value
    NoteScreen(
        notes = notesList ,
        onRemoveNote = {
            noteViewModel.removeNote(it)
        },
        onAddNote = {
            noteViewModel.addNote(it)
        }
    )

}
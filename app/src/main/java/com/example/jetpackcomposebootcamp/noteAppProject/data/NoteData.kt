package com.example.jetpackcomposebootcamp.noteAppProject.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.jetpackcomposebootcamp.noteAppProject.model.Note


class NoteDataSource{

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadNotes():List<Note>{
        return listOf(
            Note(title = "Iran", description = "Iran Is the best Land In the world"),
            Note(title = "Iran", description = "Iran Is the best Land In the world"),
            Note(title = "Iran", description = "Iran Is the best Land In the world"),
            Note(title = "Iran", description = "Iran Is the best Land In the world"),
            Note(title = "Iran", description = "Iran Is the best Land In the world"),
            Note(title = "Iran", description = "Iran Is the best Land In the world"),
            Note(title = "Iran", description = "Iran Is the best Land In the world"),
            Note(title = "Iran", description = "Iran Is the best Land In the world"),
            Note(title = "Iran", description = "Iran Is the best Land In the world"),
        )
    }

}
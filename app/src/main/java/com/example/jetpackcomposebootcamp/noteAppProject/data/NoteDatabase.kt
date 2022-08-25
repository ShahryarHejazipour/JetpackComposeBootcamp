package com.example.jetpackcomposebootcamp.noteAppProject.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpackcomposebootcamp.noteAppProject.model.Note


@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase(){

    abstract fun noteDAO() : NoteDatabaseDAO
}
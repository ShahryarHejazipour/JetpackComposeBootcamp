package com.example.jetpackcomposebootcamp.noteAppProject.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jetpackcomposebootcamp.noteAppProject.model.Note
import com.example.jetpackcomposebootcamp.noteAppProject.util.DateConverter
import com.example.jetpackcomposebootcamp.noteAppProject.util.UUIDConverter


@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase(){

    abstract fun noteDAO() : NoteDatabaseDAO
}
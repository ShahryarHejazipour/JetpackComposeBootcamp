package com.example.jetpackcomposebootcamp.noteAppProject.di

import android.content.Context
import androidx.room.Room
import com.example.jetpackcomposebootcamp.noteAppProject.data.NoteDatabase
import com.example.jetpackcomposebootcamp.noteAppProject.data.NoteDatabaseDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase):NoteDatabaseDAO
    = noteDatabase.noteDAO()


    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context):NoteDatabase
    = Room.databaseBuilder(context,NoteDatabase::class.java,"notes.db").fallbackToDestructiveMigration().build()

}
package com.example.jetpackcomposebootcamp.noteAppProject.repository

import com.example.jetpackcomposebootcamp.noteAppProject.data.NoteDatabaseDAO
import com.example.jetpackcomposebootcamp.noteAppProject.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDAO: NoteDatabaseDAO) {

    suspend fun addNote(note: Note) = noteDatabaseDAO.insert(note = note)
    suspend fun updateNote(note: Note) = noteDatabaseDAO.update(note = note)
    suspend fun deleteNote(note: Note) = noteDatabaseDAO.delete(note = note)
    suspend fun deleteAllNotes() = noteDatabaseDAO.deleteAll()
    suspend fun getAllNotes() : Flow<List<Note>> = noteDatabaseDAO.getNotes().flowOn(Dispatchers.IO).conflate()
}
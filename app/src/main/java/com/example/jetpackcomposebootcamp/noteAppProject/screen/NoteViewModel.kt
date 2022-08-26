package com.example.jetpackcomposebootcamp.noteAppProject.screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposebootcamp.noteAppProject.data.NoteDataSource
import com.example.jetpackcomposebootcamp.noteAppProject.model.Note
import com.example.jetpackcomposebootcamp.noteAppProject.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

  //  private val noteList = mutableStateListOf<Note>()
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
     val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged().collect{ listOfNotes ->
                if (listOfNotes.isNullOrEmpty()){
                    Log.d("Empty", "EmptyList: List Is Empty")
                }else{
                    _noteList.value = listOfNotes
                }
            }
        }
    }

     fun addNote(note:Note) = viewModelScope.launch { repository.addNote(note) }
      fun removeNote(note:Note) = viewModelScope.launch { repository.deleteNote(note) }
     fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }
}
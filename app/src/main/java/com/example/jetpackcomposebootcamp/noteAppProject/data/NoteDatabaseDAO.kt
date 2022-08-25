package com.example.jetpackcomposebootcamp.noteAppProject.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.jetpackcomposebootcamp.noteAppProject.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDatabaseDAO {

    @Query("SELECT * FROM notes_tbl")
    fun getNotes():Flow<List<Note>>

    @Query("SELECT * FROM notes_tbl where id=:id")
   suspend fun getNoteById(id:String):Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
  suspend  fun update(note: Note)

    @Query("DELETE FROM notes_tbl")
   suspend fun deleteAll()

    @Delete
   suspend fun delete(note: Note)


}

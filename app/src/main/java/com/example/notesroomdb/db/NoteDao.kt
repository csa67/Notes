package com.example.notesroomdb.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notesroomdb.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {

    @Query("SELECT * FROM Note order by id DESC")
    fun getAllNotes() : Flow<List<Note>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)
}
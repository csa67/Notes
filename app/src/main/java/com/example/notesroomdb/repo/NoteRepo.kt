package com.example.notesroomdb.repo

import com.example.notesroomdb.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepo {

    suspend fun addNote(note: Note)
    fun getAllNotes(): Flow<List<Note>>

}

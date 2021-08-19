package com.example.notesroomdb.repo

import com.example.notesroomdb.MyApplication
import com.example.notesroomdb.db.NoteDao
import com.example.notesroomdb.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepoImpl(private val noteDao: NoteDao): NoteRepo {
    override suspend fun addNote(note: Note) {
        noteDao.addNote(note)
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes()
    }
}
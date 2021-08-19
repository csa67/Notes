package com.example.notesroomdb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.notesroomdb.model.Note
import com.example.notesroomdb.repo.NoteRepo
import kotlinx.coroutines.launch

class NotesViewModel(private val noteRepo: NoteRepo): ViewModel() {

    val notesList: LiveData<List<Note>> = noteRepo.getAllNotes().asLiveData()

    fun addNote(noteItem: Note) {
        viewModelScope.launch{
            noteRepo.addNote(noteItem)
        }
    }

}
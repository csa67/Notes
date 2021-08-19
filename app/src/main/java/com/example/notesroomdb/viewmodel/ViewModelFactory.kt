package com.example.notesroomdb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesroomdb.MyApplication
import com.example.notesroomdb.repo.NoteRepo
import com.example.notesroomdb.repo.NoteRepoImpl
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repo: NoteRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NotesViewModel::class.java)){
            return NotesViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown Class Name")
    }


}
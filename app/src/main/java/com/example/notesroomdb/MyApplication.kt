package com.example.notesroomdb

import android.app.Application
import com.example.notesroomdb.db.NoteDataBase
import com.example.notesroomdb.repo.NoteRepoImpl

class MyApplication : Application() {

    val database by lazy { NoteDataBase.getDatabase(this) }
    val repository by lazy { NoteRepoImpl(database.noteDao()) }
}
package com.example.notesroomdb.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val title:String,
    val message:String
)
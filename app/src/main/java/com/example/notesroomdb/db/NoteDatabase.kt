package com.example.notesroomdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesroomdb.model.Note

@Database(entities = [Note::class],version =1, exportSchema = false)
abstract class NoteDataBase: RoomDatabase() {

    abstract fun noteDao(): NoteDao
    companion object{

        @Volatile
        private var INSTANCE: NoteDataBase?= null

        fun getDatabase(context: Context): NoteDataBase{

            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDataBase::class.java,
                    "notes_db"
                ).build()
                INSTANCE = instance

                instance
            }
        }

    }
}
package com.example.notesroomdb.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesroomdb.MyApplication
import com.example.notesroomdb.R
import com.example.notesroomdb.databinding.ActivityMainBinding
import com.example.notesroomdb.viewmodel.NotesViewModel
import com.example.notesroomdb.viewmodel.ViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private val noteViewModel: NotesViewModel by lazy{
        ViewModelProvider(this, ViewModelFactory((application as MyApplication).repository)).get(NotesViewModel::class.java)
    }

    private var adapter:Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setupUI()
        title = "Notes"

    }

    private fun setupUI() {

        //val rv = findViewById<RecyclerView>(R.id.rv)
        //val addNote = findViewById<Button>(R.id.btnAddNote)

        binding.btnAddNote.setOnClickListener {
            val intent = Intent(this, NewNote::class.java)
            startActivity(intent)
        }

        adapter = Adapter(emptyList())

        binding.apply {
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(applicationContext)
         }

        noteViewModel.notesList.observe(this, {note ->
            note?.let { list ->
                adapter?.update(list)
            }
        }
        )
    }


}

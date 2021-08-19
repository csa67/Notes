package com.example.notesroomdb.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.notesroomdb.MyApplication
import com.example.notesroomdb.R
import com.example.notesroomdb.databinding.ActivityNewNoteBinding
import com.example.notesroomdb.model.Note
import com.example.notesroomdb.viewmodel.NotesViewModel
import com.example.notesroomdb.viewmodel.ViewModelFactory

class NewNote : AppCompatActivity() {

    private lateinit var binding: ActivityNewNoteBinding
    private lateinit var notesViewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_note)
        title = "New Note"
        setupViewModel()
        setupView()
    }

    private fun setupViewModel() {
        notesViewModel = ViewModelProvider(this, ViewModelFactory((application as MyApplication).repository)).get(NotesViewModel::class.java)
    }

    private fun setupView() {

            binding.buttonDone.setOnClickListener {
                if (binding.textViewAddTitle.text.isNotEmpty() || binding.textViewAddContent.text.isNotEmpty()) {
                    notesViewModel.addNote(
                        Note(
                            title = binding.textViewAddTitle.text.toString(),
                            message = binding.textViewAddContent.text.toString(),
                        )
                    )

                   //val imm: InputMethodManager =
                    //    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    //imm.hideSoftInputFromWindow(it.windowToken, 0)

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Enter Data First", Toast.LENGTH_LONG).show()
                }
        }
    }





}


package com.example.notesroomdb.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesroomdb.R
import com.example.notesroomdb.databinding.ActivityMainBinding
import com.example.notesroomdb.model.Note

class Adapter(private var notesList: List<Note>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    fun update(notesList: List<Note>){
        this.notesList= notesList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        //val binding = ActivityMainBinding.inflate(inflater,parent,false)
        val view = inflater.inflate(R.layout.note_item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notesList[position]

        holder.title.text = note.title
        holder.message.text = note.message

    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val title = view.findViewById<TextView>(R.id.txtTitle)
        val message = view.findViewById<TextView>(R.id.txtMessage)



    }
}
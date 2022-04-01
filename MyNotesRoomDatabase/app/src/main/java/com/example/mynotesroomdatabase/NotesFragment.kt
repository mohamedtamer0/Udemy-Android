package com.example.mynotesroomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.room.Room
import com.example.mynotesroomdatabase.data.Note
import com.example.mynotesroomdatabase.data.database.NoteDatabase
import com.example.mynotesroomdatabase.databinding.FragmentNotesBinding


class NotesFragment : Fragment() {
    private lateinit var binding: FragmentNotesBinding
    private val viewModel by activityViewModels<NotesViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }


}
package com.example.mynotesroomdatabase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mynotesroomdatabase.data.Note
import com.example.mynotesroomdatabase.data.database.NoteDatabase
import com.example.mynotesroomdatabase.data.database.repository.NoteRepository
import io.reactivex.rxjava3.schedulers.Schedulers

class NotesViewModel : ViewModel() {
    val newNoteText = MutableLiveData<String>()

    private val _notes = MutableLiveData<List<Note>>()
    val notes:LiveData<List<Note>> = _notes


    val repository = NoteRepository()

    fun addNote() {
        newNoteText.value?.let {
            repository.insertNewNote(Note(0, it, "2022/3/31", false))
                .subscribeOn(Schedulers.io())
                .subscribe()
            newNoteText.postValue("")
        }

    }
}
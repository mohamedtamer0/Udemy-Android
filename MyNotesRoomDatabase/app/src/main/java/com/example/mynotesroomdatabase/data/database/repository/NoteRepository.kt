package com.example.mynotesroomdatabase.data.database.repository

import com.example.mynotesroomdatabase.data.Note
import com.example.mynotesroomdatabase.data.database.NoteDatabase
import io.reactivex.rxjava3.core.Completable

class NoteRepository {
    val dao = NoteDatabase.getInstanceWithoutContext().noteDao()

    fun insertNewNote(note: Note) :Completable{
        return dao.insertNote(note)
    }
}
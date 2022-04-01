package com.example.mynotesroomdatabase.data.database

import androidx.room.*
import com.example.mynotesroomdatabase.data.Note
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note): Completable

    @Delete
    fun delete(note: Note): Completable

    @Update
    fun update(note: Note): Completable

    @Query("select * from note_table")
    fun getAllNotes(): Single<List<Note>>

}
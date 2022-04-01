package com.example.mynotesroomdatabase.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val content: String,
    val date: String,
    val isImportant: Boolean
)

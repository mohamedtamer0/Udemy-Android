package com.example.mysolid

interface IDatabase {
    fun getAllStudents(): List<Student>
    fun getAllStudentsCount(): Int
}

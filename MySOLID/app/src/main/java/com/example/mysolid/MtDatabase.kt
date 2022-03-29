package com.example.mysolid

class MtDatabase:IDatabase {

    fun getStudents(): List<Student> {
        return listOf(
            Student("Mohamed", 25),
            Student("Osama", 30),
            Student("Ahmed", 25)
        )
    }


    fun getStudentsCount(): Int {
        return getStudents().size
    }

    override fun getAllStudents(): List<Student> {
        return getStudents()
    }

    override fun getAllStudentsCount(): Int {
        return getStudentsCount()
    }
}
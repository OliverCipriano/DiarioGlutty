
package com.ejemplo.diarioglutty.repository

import android.content.Context
import androidx.room.Room
import com.ejemplo.diarioglutty.model.db.AppDatabase
import com.ejemplo.diarioglutty.model.entity.NoteEntity

class NoteRepository private constructor(context: Context) {
    private val db = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "notas.db"
    ).fallbackToDestructiveMigration().build()

    private val dao = db.noteDao()

    fun notesFlow() = dao.observeAll()
    suspend fun add(text: String, photoUri: String?, date: String) =
        dao.insert(NoteEntity(text = text.trim(), photoUri = photoUri, date = date))

    suspend fun delete(id: Long) =
        dao.delete(NoteEntity(id = id, text = "", photoUri = null, date = null))

    companion object {
        @Volatile private var INSTANCE: NoteRepository? = null
        fun get(context: Context) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: NoteRepository(context).also { INSTANCE = it }
            }
    }
}

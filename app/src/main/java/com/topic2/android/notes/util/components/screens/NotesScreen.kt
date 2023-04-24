package com.topic2.android.notes.util.components.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.topic2.android.notes.domain.model.NoteModel
import com.topic2.android.notes.viewmodel.MainViewModel
import com.topic2.android.notes.util.components.Note
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import com.topic2.android.notes.util.components.TopAppBar
import androidx.compose.runtime.getValue

@Composable
fun NotesScreen(viewModel: MainViewModel) {
    val notes: List<NoteModel> by viewModel
        .notesNotInTrash
        .observeAsState(listOf())
    Column {
        TopAppBar(title = "Заметки" ,
            icon = Icons.Filled.List,
            onIconClick ={}
        )

        LazyColumn {
            items(count = notes.size) { noteIndex ->
                val note = notes[noteIndex]
                Note(
                    note = note,
                    onNoteClick = {viewModel.onNoteClick(it)},
                    onNoteCheckedChange = {viewModel.onNoteCheckedChange(it)}
                )
            }
        }
    }


}


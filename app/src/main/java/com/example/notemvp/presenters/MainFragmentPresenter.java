package com.example.notemvp.presenters;

import androidx.lifecycle.LiveData;
import com.example.notemvp.data.NotesDao;
import com.example.notemvp.model.Note;

import java.util.List;

public class MainFragmentPresenter implements IMainPresenter {

    private NotesDao notesDao;

    public MainFragmentPresenter(NotesDao notesDao) {
        this.notesDao = notesDao;
    }

    @Override
    public LiveData<List<Note>> getData() {
         return notesDao.getAllNotes();
    }

    @Override
    public void onNoteClicked() {
    }

    @Override
    public void deleteNote(int position) {
    }
}

package com.example.notemvp.presenters;


import androidx.lifecycle.LiveData;

import com.example.notemvp.model.Note;

import java.util.List;

public interface IMainPresenter {
    void onNoteClicked();
    void deleteNote(int position);
    void onCreateNoteClicked();
    LiveData<List<Note>> getData();
}

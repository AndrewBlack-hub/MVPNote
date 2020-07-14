package com.example.notemvp.presenters;

import android.content.Context;

import com.example.notemvp.model.Note;

public interface ICreateNotePresenter {
    void saveNote(Note note);
    void updateNote(Note note);
    void createAlertDialog(Context context);
    boolean validation(String title, String description);
    void clickSaveNote(String title, String description);
    String date();
}

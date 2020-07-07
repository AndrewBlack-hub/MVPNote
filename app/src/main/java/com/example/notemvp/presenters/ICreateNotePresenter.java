package com.example.notemvp.presenters;

import com.example.notemvp.model.Note;

public interface ICreateNotePresenter {
    void saveNote(Note note);
    void updateNote(Note note);
    void onClickedBtnHome();
    void clickSaveNote(String title, String description);
    String date();
}

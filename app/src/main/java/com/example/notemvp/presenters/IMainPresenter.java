package com.example.notemvp.presenters;


public interface IMainPresenter {
    void onNoteClicked();
    void deleteNote(int position);
    void onCreateNoteClicked();
    void Data();
}

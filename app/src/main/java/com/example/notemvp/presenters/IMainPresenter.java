package com.example.notemvp.presenters;

import androidx.lifecycle.LifecycleOwner;

public interface IMainPresenter {
    void onNoteClicked();
    void deleteNote(int position);
    void onCreateNoteClicked();
    void getData(LifecycleOwner owner);
}

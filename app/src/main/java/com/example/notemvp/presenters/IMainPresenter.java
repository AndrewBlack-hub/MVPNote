package com.example.notemvp.presenters;


import android.os.Bundle;
import androidx.lifecycle.LiveData;

import com.example.notemvp.model.Note;

import java.util.List;

public interface IMainPresenter {
    Bundle createBundleForNote(Note note);
    void deleteNote(Note note);
    void insertNote(Note note);
    LiveData<List<Note>> getData();
}

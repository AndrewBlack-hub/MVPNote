package com.example.notemvp.presenters;


import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;

import com.example.notemvp.model.Note;

import java.util.List;

public interface IMainPresenter {
    Bundle sendNote(Note note);
    void deleteNote(int position);
    LiveData<List<Note>> getData();
}

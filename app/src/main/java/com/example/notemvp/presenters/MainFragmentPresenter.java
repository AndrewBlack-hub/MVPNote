package com.example.notemvp.presenters;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import com.example.notemvp.R;
import com.example.notemvp.adapter.NotesAdapter;
import com.example.notemvp.data.App;
import com.example.notemvp.data.NotesDao;
import com.example.notemvp.model.Note;

import java.lang.ref.WeakReference;
import java.util.List;

public class MainFragmentPresenter implements IMainPresenter {

    private WeakReference<Context> contextWR;
    private NotesDao notesDao;
    private NavController navController;
    public LiveData<List<Note>> notes;
    private BasePresenter basePresenter;

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

    @Override
    public void onCreateNoteClicked() {
        navController.navigate(R.id.dest_create_note);
    }

}

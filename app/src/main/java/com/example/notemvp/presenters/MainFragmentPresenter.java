package com.example.notemvp.presenters;

import android.os.Bundle;

import androidx.lifecycle.LiveData;

import com.example.notemvp.CreateNoteFragment;
import com.example.notemvp.data.NotesDao;
import com.example.notemvp.model.Note;

import java.util.List;

public class MainFragmentPresenter implements IMainPresenter {

    private NotesDao notesDao;
    public static final String BUNDLE_KEY = "note";

    public MainFragmentPresenter(NotesDao notesDao) {
        this.notesDao = notesDao;
    }

    @Override
    public LiveData<List<Note>> getData() {
         return notesDao.getAllNotes();
    }

    public Bundle createBundleForNote(Note note) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_KEY, note);
        CreateNoteFragment fragment = new CreateNoteFragment();
        fragment.setArguments(bundle);
        return bundle;
    }

    @Override
    public void deleteNote(int position) {
    }
}

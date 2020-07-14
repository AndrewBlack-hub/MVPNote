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
    public Note createLocaleNote(Note note) {
        return new Note(note.getId(), note.getTitle(), note.getDescription(), note.getDate());
    }

    @Override
    public void deleteNote(Note note) {
        notesDao.deleteNote(note);
    }

    @Override
    public void insertNote(Note note) {
        notesDao.insertNote(note);
    }
}

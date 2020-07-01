package com.example.notemvp.presenters;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import com.example.notemvp.R;
import com.example.notemvp.adapter.NotesAdapter;
import com.example.notemvp.data.App;
import com.example.notemvp.model.Note;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainFragmentPresenter implements IMainPresenter {

    private WeakReference<Context> contextWR;
    private NavController navController;
    private List<Note> notes = new ArrayList<>();
    private NotesAdapter adapter = new NotesAdapter();

    public MainFragmentPresenter(Context context) {
        contextWR = new WeakReference<>(context);
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

    @Override
    public void getData(LifecycleOwner owner) {
        LiveData<List<Note>> notesFromDB = App.getInstance().getDatabase().notesDao().getAllNotes();
        notesFromDB.observe(owner, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notesFromLiveData) {
                notes.clear();
                notes.addAll(notesFromLiveData);
                adapter.notifyDataSetChanged();
            }
        });
    }
}

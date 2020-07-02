package com.example.notemvp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notemvp.adapter.NotesAdapter;
import com.example.notemvp.data.App;
import com.example.notemvp.model.Note;
import com.example.notemvp.presenters.IMainPresenter;
import com.example.notemvp.presenters.MainFragmentPresenter;

import java.util.List;

public class MainFragment extends Fragment {

    private RecyclerView recyclerViewListNotes;
    private NotesAdapter adapter = new NotesAdapter();
    private IMainPresenter presenter = new MainFragmentPresenter(App.getInstance().getDatabase().notesDao());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewListNotes = view.findViewById(R.id.recyclerViewMainFragment);
        recyclerViewListNotes.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewListNotes.setAdapter(adapter);
        presenter.getData().observe(getViewLifecycleOwner(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notesFromLiveData) {
                adapter.submitList(notesFromLiveData);
            }
        });
    }
}
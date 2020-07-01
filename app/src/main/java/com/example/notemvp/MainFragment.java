package com.example.notemvp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notemvp.adapter.NotesAdapter;
import com.example.notemvp.presenters.IMainPresenter;
import com.example.notemvp.presenters.MainFragmentPresenter;

public class MainFragment extends Fragment {

    private RecyclerView recyclerViewListNotes;
    private NotesAdapter adapter;
    private IMainPresenter presenter = new MainFragmentPresenter(getContext());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewListNotes = view.findViewById(R.id.recyclerViewMainFragment);
        adapter = new NotesAdapter();
        recyclerViewListNotes.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewListNotes.setAdapter(adapter);
    }
}
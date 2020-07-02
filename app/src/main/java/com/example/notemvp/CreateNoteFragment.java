package com.example.notemvp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notemvp.presenters.CreateNotePresenter;
import com.example.notemvp.presenters.ICreateNotePresenter;


public class CreateNoteFragment extends Fragment implements ICreateNoteView {

    private EditText editTextTitle;
    private EditText editTextDescription;

    private ICreateNotePresenter presenter = new CreateNotePresenter(this);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_create_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextTitle = view.findViewById(R.id.editTextTitle);
        editTextDescription = view.findViewById(R.id.editTextDescription);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_save_note) {
            String title = editTextTitle.getText().toString();
            String description = editTextDescription.getText().toString();
            presenter.clickSaveNote(title, description);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_item, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void showMsgFailValid() {
        Toast.makeText(getContext(), R.string.enter_all_fields, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessful() {
        Toast.makeText(getContext(), R.string.successful_saving, Toast.LENGTH_SHORT).show();
        editTextTitle.setText("");
        editTextDescription.setText("");
    }
}
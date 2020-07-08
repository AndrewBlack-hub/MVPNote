package com.example.notemvp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notemvp.model.Note;
import com.example.notemvp.presenters.CreateNotePresenter;
import com.example.notemvp.presenters.ICreateNotePresenter;


public class CreateNoteFragment extends Fragment implements ICreateNoteView {

    private EditText editTextTitle;
    private EditText editTextDescription;
    private TextView textViewDate;
    private Note note;

    private static final String BUNDLE_KEY = "note";

    private ICreateNotePresenter presenter = new CreateNotePresenter(this);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_create_note, container, false);
        editTextTitle = view.findViewById(R.id.editTextTitle);
        editTextDescription = view.findViewById(R.id.editTextDescription);
        textViewDate = view.findViewById(R.id.textViewDateOfChangeNote);
        Bundle bundle = getArguments();
        if (bundle != null) {
            note = bundle.getParcelable(BUNDLE_KEY);
            initComponents(note);
        }
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_save_note) {
            String title = editTextTitle.getText().toString();
            String description = editTextDescription.getText().toString();
            if (note != null) {
                presenter.updateNote(new Note(note.getId(), title, description, presenter.date()));
                Navigation.findNavController(getView()).navigate(R.id.home_dest);
            } else {
                presenter.clickSaveNote(title, description);
                Navigation.findNavController(getView()).navigate(R.id.home_dest);
            }

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

    @Override
    public void initComponents(Note note) {
        editTextTitle.setText(note.getTitle());
        editTextDescription.setText(note.getDescription());
        textViewDate.setVisibility(View.VISIBLE);
        textViewDate.setText(String.format(getResources().getString(R.string.date_of_update), note.getDate()));
    }
}
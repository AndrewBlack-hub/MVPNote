package com.example.notemvp.presenters;

import com.example.notemvp.ICreateNoteView;
import com.example.notemvp.data.App;
import com.example.notemvp.data.NotesDao;
import com.example.notemvp.model.Note;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateNotePresenter implements ICreateNotePresenter {

    private NotesDao notesDao = App.getInstance().getDatabase().notesDao();

    public CreateNotePresenter(ICreateNoteView view) {
    }

    @Override
    public boolean validation(String title, String description) {
        return !(title.isEmpty() || description.isEmpty());
    }

    public void clickSaveNote(String title, String description) {
        Note note = new Note(title, description, date());
        saveNote(note);
    }

    @Override
    public void saveNote(Note note) {
        notesDao.insertNote(note);
    }

    @Override
    public void updateNote(Note note) {
        notesDao.updateNote(note);
    }

    @Override
    public String date() {
        Date currentDate = Calendar.getInstance().getTime();
        return DateFormat.getDateTimeInstance().format(currentDate);
    }
}

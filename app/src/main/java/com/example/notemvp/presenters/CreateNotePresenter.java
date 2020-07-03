package com.example.notemvp.presenters;

import com.example.notemvp.ICreateNoteView;
import com.example.notemvp.data.App;
import com.example.notemvp.data.NotesDao;
import com.example.notemvp.model.Note;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateNotePresenter implements ICreateNotePresenter {

    private ICreateNoteView view;
    private NotesDao notesDao = App.getInstance().getDatabase().notesDao();

    public CreateNotePresenter(ICreateNoteView view) {
        this.view = view;
    }

    private boolean validation(String title, String description) {
        return !(title.isEmpty() || description.isEmpty());
    }

    public void clickSaveNote(String title, String description) {
        if (validation(title, description)){
            Note note = new Note(title, description, date());
            notesDao.insertNote(note);
            view.showSuccessful();
        } else {
            view.showMsgFailValid();
        }
    }

    @Override
    public void saveNote(Note note) {
        notesDao.insertNote(note);

    }

    @Override
    public void onClickedBtnHome() {
    }

    private String date() {
        Date currentDate = Calendar.getInstance().getTime();
        return DateFormat.getDateTimeInstance().format(currentDate);
    }
}

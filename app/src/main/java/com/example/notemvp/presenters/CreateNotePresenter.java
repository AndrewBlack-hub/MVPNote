package com.example.notemvp.presenters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.notemvp.ICreateNoteView;
import com.example.notemvp.R;
import com.example.notemvp.data.App;
import com.example.notemvp.data.NotesDao;
import com.example.notemvp.model.Note;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateNotePresenter implements ICreateNotePresenter {

    ICreateNoteView view;
    private NotesDao notesDao = App.getInstance().getDatabase().notesDao();

    public CreateNotePresenter(ICreateNoteView view) {
        this.view = view;
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
    public void createAlertDialog(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setMessage(R.string.save_the_changes)
                .setCancelable(false)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (validation(view.getTitleFromEditText(),
                                view.getDescriptionFromEditText())) {
                            updateNote(view.newNoteForEquals());
                            view.goHome();
                        } else {
                            view.showMsgFailValid();
                        }
                    }
                });
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                view.goHome();
            }
        }).create().show();
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

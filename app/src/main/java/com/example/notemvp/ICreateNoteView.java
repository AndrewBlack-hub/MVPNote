package com.example.notemvp;

import com.example.notemvp.model.Note;

public interface ICreateNoteView {
    void goHome();
    String getTitleFromEditText();
    String getDescriptionFromEditText();
    void showMsgFailValid();
    void showSuccessful();
    void initComponents(Note note);
    Note newNoteForEquals();
}

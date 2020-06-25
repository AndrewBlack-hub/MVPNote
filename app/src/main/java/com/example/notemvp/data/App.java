package com.example.notemvp.data;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {

    private static App instance;

    private NotesDatabase database;
    private NotesDao notesDao;
    private final String DB_NAME = "notes.db";

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(getApplicationContext(), NotesDatabase.class, DB_NAME)
                .build();

        notesDao = database.notesDao();
    }

    public NotesDatabase getDatabase() {
        return database;
    }

    public void setDatabase(NotesDatabase database) {
        this.database = database;
    }

    public NotesDao getNotesDao() {
        return notesDao;
    }

    public void setNotesDao(NotesDao notesDao) {
        this.notesDao = notesDao;
    }
}

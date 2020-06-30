package com.example.notemvp.presenters;

import android.content.Context;
import androidx.navigation.NavController;
import com.example.notemvp.R;
import java.lang.ref.WeakReference;

public class MainFragmentPresenter implements IMainPresenter {

    private WeakReference<Context> contextWR;
    private NavController navController;

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
}

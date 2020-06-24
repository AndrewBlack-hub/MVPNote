package com.example.notemvp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mainToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mainToolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        setupNavigationController(navController);
    }

    private void setupNavigationController(NavController navController) {
        NavigationUI.setupActionBarWithNavController(this, navController);
    }


}
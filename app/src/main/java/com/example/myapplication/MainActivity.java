package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNavigationLinks(View view)
    {

        // retrieve the database and pass it to TempNavigationLinks Activity
        Intent intent = getIntent();
        Database database = (Database)intent.getSerializableExtra("database");
        Intent intentI = new Intent(this, TempNavigationLinks.class);
        intentI.putExtra("database", database);
        startActivity(intentI);
    }

    public void onClickLogOutButton(View view) {

        // Brief message
        // Shows create account page

        // retrieve the database
        Intent intent = getIntent();
        Database database = (Database)intent.getSerializableExtra("database");
        Toast.makeText(this, "See you again soon!", Toast.LENGTH_LONG).show();

        // pass the database to Login Page Activity
        Intent intentI = new Intent(this, LoginPage.class);
        intentI.putExtra("database", database);
        startActivity(intentI);
    }
}
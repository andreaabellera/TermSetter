package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TempNavigationLinks extends AppCompatActivity {

    Intent intent = getIntent();
    Database database = (Database)intent.getSerializableExtra("database");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_navigation_links);
    }

    public void openOfferedClassesCategories(View view)
    {
        Intent intent = new Intent(this, OfferedClassesCategories.class);
        startActivity(intent);
    }

    public void openAccountManagementMenu(View view)
    {
        Intent intent = new Intent(this, AccountManagementMenu.class);
        intent.putExtra("database", database);
        startActivity(intent);
    }
}
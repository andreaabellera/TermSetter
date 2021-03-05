package com.example.termsetter.Presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.termsetter.Persistence.DomainSpecific.Database;
import com.example.termsetter.R;

public class TempNavigationLinks extends AppCompatActivity {

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
        Intent intent = getIntent();
        Database database = (Database)intent.getSerializableExtra("database");
        Intent intentI = new Intent(this, AccountManagementMenu.class);
        intentI.putExtra("database", database);
        startActivity(intentI);
    }
}
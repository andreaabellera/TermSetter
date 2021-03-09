package comp3350.termsetter.Presentation;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.termsetter.R;

import comp3350.termsetter.Persistence.DomainSpecific.Database;

public class TempNavigationLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_navigation_links);
    }

    public void openOfferedClassesCategories(View view) {
        Intent intent = new Intent(this, OfferedClassesCategories.class);
        startActivity(intent);
    }

    public void openAccountManagementMenu(View view) {
        Intent intent = getIntent();
        Database database = (Database) intent.getSerializableExtra("database");
        Intent intentI = new Intent(this, AccountManagementMenu.class);
        intentI.putExtra("database", database);
        startActivity(intentI);
    }
}
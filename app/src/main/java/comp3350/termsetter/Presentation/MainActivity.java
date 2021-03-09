package comp3350.termsetter.Presentation;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.termsetter.R;

import comp3350.termsetter.Persistence.DomainSpecific.Database;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNavigationLinks(View view) {
        Intent intent = getIntent();
        Database database = (Database) intent.getSerializableExtra("database");
        Intent intentI = new Intent(this, TempNavigationLinks.class);
        intentI.putExtra("database", database);
        startActivity(intentI);
    }

    public void onClickLogOutButton(View view) {

        // Brief message
        // Shows create account page
        Intent intent = getIntent();
        Database database = (Database) intent.getSerializableExtra("database");
        Toast.makeText(this, "See you again soon!", Toast.LENGTH_LONG).show();
        Intent intentI = new Intent(this, LoginPage.class);
        intentI.putExtra("database", database);
        startActivity(intentI);
    }
}
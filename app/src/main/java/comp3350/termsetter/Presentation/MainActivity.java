package comp3350.termsetter.Presentation;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.termsetter.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*public void openNavigationLinks(View view) {
        Intent intent = getIntent();
        Database database = (Database) intent.getSerializableExtra("database");
        Intent intentI = new Intent(this, TempNavigationLinks.class);
        intentI.putExtra("database", database);
        startActivity(intentI);
    }*/

    public void openMyCourses(View view) {
        // code
        // (idk which class we want this to connect to)
    }

    public void openOfferedClassesCategories(View view) {
        Intent intent = new Intent(this, OfferedClassesCategories.class);
        startActivity(intent);
    }



    public void openAccountManagementMenu(View view) {
        Intent intent = new Intent(this, AccountManagementMenu.class);
        startActivity(intent);
    }


    public void onClickLogOutButton(View view) {
        // Brief message
        // Shows create account page
        Toast.makeText(this, "See you again soon!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
}
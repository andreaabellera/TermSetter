package com.example.myapplication;

import android.content.res.AssetManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class OfferedClassesCategories extends AppCompatActivity {

    CourseCategoryDriver courseDatabase;
    int btnCount = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offered_classes_categories);
        init();
    }

    public void openClassViewAcc(View view) {
        Intent intent = new Intent(this, OfferedClassesView.class);
        intent.putExtra("faculty", courseDatabase.getFaculty(0));
        startActivity(intent);
    }

    public void openClassViewCS(View view) {
        Intent intent = new Intent(this, OfferedClassesView.class);
        intent.putExtra("faculty", courseDatabase.getFaculty(1));
        startActivity(intent);
    }

    public void openClassViewMath(View view) {
        Intent intent = new Intent(this, OfferedClassesView.class);
        intent.putExtra("faculty", courseDatabase.getFaculty(2));
        startActivity(intent);
    }

    public void openClassViewMIS(View view) {
        Intent intent = new Intent(this, OfferedClassesView.class);
        intent.putExtra("faculty", courseDatabase.getFaculty(3));
        startActivity(intent);
    }

    private void init(){

        try{
            InputStream is = getResources().openRawResource(R.raw.classdb);
            courseDatabase = new CourseCategoryDriver(is);

            for(int i = 0; i < btnCount; i++) {
                int num = i + 1; // must be done explicitly
                int btnID = getResources().getIdentifier("category" + num + "_btn", "id", getPackageName());
                Button button = findViewById(btnID);
                button.setText(courseDatabase.getFaculty(i).getName());
            }
        }
        catch(IOException e){
            System.out.println("Database source file 'classdb.txt' is missing from res/assets.");
            e.printStackTrace();
        }
    }
}
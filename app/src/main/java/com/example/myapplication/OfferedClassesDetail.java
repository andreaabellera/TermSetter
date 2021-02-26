package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class OfferedClassesDetail extends AppCompatActivity {

    CourseOffering course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offered_classes_detail);
        init();
    }

    private void init(){
        course = (CourseOffering) getIntent().getSerializableExtra("course");
        TextView selectedClass = findViewById(R.id.selectedClass_txt);
        selectedClass.setText(course.getCourseCode());
        TextView selectedClassName = findViewById(R.id.selectedClassName_txt);
        selectedClassName.setText(course.getName());
        TextView selectedClassCred = findViewById(R.id.selectedClassCred_txt);
        selectedClassCred.setText(Integer.toString(course.getCreditHours())+".00CR");
    }

    public void openCategories(View view) {
        String section = "";
        int s1_id = getResources().getIdentifier("s1_rbtn", "id", getPackageName());
        RadioGroup rg = findViewById(R.id.sections_rgrp);
        if(rg.getCheckedRadioButtonId() == s1_id){
            section = "A01";
        }
        else{
            section = "A02";
        }

        Toast.makeText(this, "Successfully enrolled in " + course.getCourseCode() + " " + section, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, OfferedClassesCategories.class);
        startActivity(intent);
    }

}
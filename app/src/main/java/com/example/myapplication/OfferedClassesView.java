package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class OfferedClassesView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offered_classes_view);
    }

    public void openClassDetail(View view) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        startActivity(intent);
    }

}
package comp3350.termsetter.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import comp3350.termsetter.R;

public class Timetable extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
    }

    private void initData() {

    }

    private void initWidgets() {

    }

    public void returnToMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
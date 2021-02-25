package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class AccountUpdateEmail extends AppCompatActivity {

    private String currEmail;
    private String newEmail;
    private String newEmailConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_update_email);
    }

    public void updateEmail(View view)
    {
        // validate new email
            // not null
            // not = curr email
        // validate confirm
            // confirm = new email
        // if both^
            // curr email = new email
    }
}
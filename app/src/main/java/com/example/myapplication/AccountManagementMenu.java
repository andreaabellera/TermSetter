package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AccountManagementMenu extends AppCompatActivity {

    Intent intent = getIntent();
    Database database = (Database)intent.getSerializableExtra("database");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_management_menu);
    }

    public void openManageProfile(View view)
    {
        Intent intent = new Intent(this, AccountManageProfile.class);
        startActivity(intent);
    }

    public void openUpdateEmail(View view)
    {
        Intent intent = new Intent(this, AccountUpdateEmail.class);
        intent.putExtra("database", database);
        startActivity(intent);
    }

    public void openChangePassword(View view)
    {
        Intent intent = new Intent(this, AccountChangePassword.class);
        intent.putExtra("database", database);
        startActivity(intent);
    }

    public void openSettings(View view)
    {
        Intent intent = new Intent(this, AccountSettings.class);
        startActivity(intent);
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccountChangePassword extends AppCompatActivity {

    // declare local variable
    private EditText oldPassword;
    private EditText newPassword;
    private EditText newPasswordConfirm;
    private Button change;
    boolean validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_change_password);
    }


    public void onClickConfirmButton(View view) {

        // Retrieving the "database" from the Account Management Menu activity
        Intent intent = getIntent();
        Database database = (Database) intent.getSerializableExtra("database");
        User user;

        // retrieving user's input and extract the text for validation
        oldPassword = findViewById(R.id.change_password_input1);
        newPassword = findViewById(R.id.change_password_input2);
        newPasswordConfirm = findViewById(R.id.change_password_input3);

        String inputOldPassword = oldPassword.getText().toString();
        String inputNewPassword = newPassword.getText().toString();
        String inputNewPasswordConfirm = newPasswordConfirm.getText().toString();

        if (inputOldPassword.isEmpty() || inputNewPassword.isEmpty() || inputNewPasswordConfirm.isEmpty()) {
            Toast.makeText(AccountChangePassword.this, "Too empty buddy, try again!", Toast.LENGTH_SHORT).show();
        } else {
            validate = validate(inputOldPassword, inputNewPassword, inputNewPasswordConfirm);
            if (validate) {

                // retrieve existing user from the database
                user = database.getUser();
                user.setEmail(inputNewPassword);
                Toast.makeText(AccountChangePassword.this, "Password changes!", Toast.LENGTH_SHORT).show();

                // another intent to pass along the database back to the Account Management Menu
                Intent intentI = new Intent(AccountChangePassword.this, AccountManagementMenu.class);
                intentI.putExtra("database", database);
                startActivity(intentI);
            } else {
                Toast.makeText(AccountChangePassword.this, "Please try again!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean validate(String oldPass, String newPass, String newPassConfirm) {

        // retrieve existing user from the database
        Intent intent = getIntent();
        Database database = (Database) intent.getSerializableExtra("database");
        User user = database.getUser();

        boolean result = false;
        if (oldPass.equals(user.getPassword())) {
            if (newPass.equals(newPassConfirm)) {
                result = true;
            }
            else {
                Toast.makeText(AccountChangePassword.this, "Please confirm your password again!", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(AccountChangePassword.this, "Your old password is incorrect!", Toast.LENGTH_SHORT).show();
        }
        return result;
    }
}
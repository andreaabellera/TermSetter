package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccountChangePassword extends AppCompatActivity {

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
        Intent intent = getIntent();
        Database database = (Database) intent.getSerializableExtra("database");

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
                database.isEmpty();
                Toast.makeText(AccountChangePassword.this, "Password changes!", Toast.LENGTH_SHORT).show();
                Intent intentI = new Intent(AccountChangePassword.this, AccountManagementMenu.class);
                intentI.putExtra("database", database);
                startActivity(intentI);
            } else {
                Toast.makeText(AccountChangePassword.this, "Please try again!", Toast.LENGTH_SHORT).show();
            }
        }
    }




    private boolean validate(String oldPass, String newPass, String newPassConfirm) {
        boolean result = false;
        Intent intent = getIntent();
        if (newPass.equals(newPassConfirm)) {
            result = true;
        }
        return result;
    }
}
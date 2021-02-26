package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class CreateAccount extends AppCompatActivity {

    private EditText eName;
    private EditText eMail;
    private EditText ePassword;
    private EditText eConfirmPassword;
    private EditText ePhone;
    private Button eCreate;
    private int idCount = 0;

    boolean validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        eName = findViewById(R.id.idText);
        eMail = findViewById(R.id.emailText);
        ePassword = findViewById(R.id.passwordText);
        eConfirmPassword = findViewById(R.id.confirmPasswordText);
        ePhone = findViewById(R.id.phoneText);
    }

    public void onClickConfirmButton(View view) {
        String inputName = eName.getText().toString();
        String inputPassword = ePassword.getText().toString();
        String inputEmail = eMail.getText().toString();
        String inputConfirmPassword = eConfirmPassword.getText().toString();
        String inputPhone = ePhone.getText().toString();

        if (inputName.isEmpty() || inputPassword.isEmpty()) {
            Toast.makeText(CreateAccount.this, "Too empty buddy, try again!", Toast.LENGTH_SHORT).show();
        }
        else {
            validate = validate(inputName, inputPassword, inputEmail, inputConfirmPassword, inputPhone);
            if (validate) {
                User user = new User(inputName, inputPassword, inputEmail, inputPhone);
                Database database = new Database();
                database.addUser(user);
                Toast.makeText(CreateAccount.this, "Welcome " + inputName + " !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CreateAccount.this, LoginPage.class);
                intent.putExtra("database", database);
                startActivity(intent);
            }
        }
    }

    public static boolean validate(String name, String password, String email, String confirmPassword, String phone) {
        boolean result = false; 
        boolean validPassword = password.equals(confirmPassword);
        boolean validName = name.length() <= 20;
        boolean validEmail = email.contains("@myumanitoba.ca");
        boolean validPhone = phone.length() <= 10;

        if (validPassword && validName && validEmail && validPhone) {
            result = true;
        }
        return result;
    }

}

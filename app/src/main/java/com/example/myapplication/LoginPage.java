package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {

    // declare local variable
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    boolean validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }

    public void onClickLoginButton(View view){
        Intent intent = getIntent();
        Database database = (Database)intent.getSerializableExtra("database");

        // If the database is not yet initialized since this is the first time the app is used
        // the program will ask users to create an account (begins at line 64)
        if (database != null) {

            // another check to see if the database is Empty
            boolean noUserExist = database.isEmpty();
            if (!noUserExist) {

                // retrieving user's input and extract the text for validation
                eName = findViewById(R.id.idText);
                ePassword = findViewById(R.id.passwordText);
                eLogin = findViewById(R.id.btnLogin);

                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(LoginPage.this, "Too empty buddy, try again!", Toast.LENGTH_SHORT).show();
                } else {
                    validate = validate(inputName, inputPassword);
                    if (validate) {
                        Toast.makeText(LoginPage.this, "Welcome " + inputName + " !", Toast.LENGTH_SHORT).show();

                        // another intent to pass along the database back to the Main Activity
                        Intent intentI = new Intent(LoginPage.this, MainActivity.class);
                        intentI.putExtra("database", database);
                        startActivity(intentI);
                    } else {
                        Toast.makeText(LoginPage.this, "Please try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
        else {
            eName = findViewById(R.id.idText);
            ePassword = findViewById(R.id.passwordText);

            String inputName = eName.getText().toString();
            String inputPassword = ePassword.getText().toString();

            if (inputName.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(LoginPage.this, "Too empty buddy, try again!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LoginPage.this, "Account doesn't exist!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean validate(String name, String password) {

        // retrieve existing user from the database
        Intent intent = getIntent();
        Database database = (Database)intent.getSerializableExtra("database");
        User user = database.getUser();

        boolean result = false;
        if (name.equals(user.getName()) && password.equals(user.getPassword())) {
            result = true;
        }
        return result;
    }

    public void onClickCreateAccountButton(View view){
        // Brief message
        // Shows create account page
        Toast.makeText(this, "Create Account Button pressed!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }
}
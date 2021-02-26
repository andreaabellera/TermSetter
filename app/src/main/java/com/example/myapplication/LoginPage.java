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
        boolean noUserExist = ((Database) getApplication()).isEmpty();
        if (!noUserExist) {
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
                    Intent intent = new Intent(LoginPage.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginPage.this, "Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private boolean validate(String name, String password) {
        User user = ((Database) getApplication()).getUser();
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
package comp3350.termsetter.Presentation;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.termsetter.Persistence.DomainSpecific.StubDatabase;
import comp3350.termsetter.R;

import comp3350.termsetter.Persistence.CreateAccount;
import comp3350.termsetter.Persistence.DomainSpecific.Database;
import comp3350.termsetter.Persistence.DomainSpecific.User;

public class LoginPage extends AppCompatActivity {

    private StubDatabase database = new StubDatabase(this,"test.db");
    boolean validate;
    private EditText eID;
    private EditText ePassword;
    private Button eLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }

    public void onClickLoginButton(View view) {

        if (database != null) {
            eID = findViewById(R.id.idText);
            ePassword = findViewById(R.id.passwordText);
            eLogin = findViewById(R.id.btnLogin);

            String inputID = eID.getText().toString();
            String inputPassword = ePassword.getText().toString();

            if (inputID.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(LoginPage.this, "Too empty buddy, try again!", Toast.LENGTH_SHORT).show();
            } else {
                validate = validate(inputID, inputPassword);
                if (validate) {
                    Toast.makeText(LoginPage.this, "Welcome " + inputID + " !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginPage.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginPage.this, "Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            eID = findViewById(R.id.idText);
            ePassword = findViewById(R.id.passwordText);

            String inputName = eID.getText().toString();
            String inputPassword = ePassword.getText().toString();

            if (inputName.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(LoginPage.this, "Too empty buddy, try again!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LoginPage.this, "Account doesn't exist!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean validate(String id, String password) {
        boolean result = false;

        if (database.checkUser(id)) {
            User user = database.getUser(id);
            if (password.equals(user.getPassword())) {
                result = true;
            }
        }
        return result;
    }

    public void onClickCreateAccountButton(View view) {
        // Brief message
        // Shows create account page
        Toast.makeText(this, "Create Account Button pressed!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }
}
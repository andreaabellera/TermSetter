package comp3350.termsetter.Presentation;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import comp3350.termsetter.Persistence.ConnectDB;
import comp3350.termsetter.Persistence.DBHelper;
import comp3350.termsetter.Persistence.Main;
import comp3350.termsetter.Persistence.DomainSpecific.StubDatabase;
import comp3350.termsetter.R;

import comp3350.termsetter.Presentation.CreateAccount;
import comp3350.termsetter.Persistence.DomainSpecific.Database;
import comp3350.termsetter.Persistence.DomainSpecific.User;

public class LoginPage extends AppCompatActivity {
    private static Context mContext;
    private StubDatabase database;
    private EditText eID;
    private EditText ePassword;
    private Button eLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mContext = getApplicationContext();
        database = new StubDatabase(mContext,"test.db");
        //try {
        //    DBHelper.copyDatabaseToDevice(this);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
    }

    public void onClickLoginButton(View view) {
        /*
            eName = findViewById(R.id.loginEdtxt1);
            ePassword = findViewById(R.id.loginEdtxt2);
            eLogin = findViewById(R.id.loginBtn);

            String inputID = eID.getText().toString();
            String inputPassword = ePassword.getText().toString();

            if (inputName.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(LoginPage.this, "Too empty buddy, try again!", Toast.LENGTH_SHORT).show();
            }
            else {
                validate = validate(inputName, inputPassword);
                if (validate) {
                    Toast.makeText(LoginPage.this, "Welcome " + inputName + " !", Toast.LENGTH_SHORT).show();
                    Intent intentI = new Intent(LoginPage.this, MainActivity.class);
                    intentI.putExtra("database", database);
                    startActivity(intentI);
                } else {
                    Toast.makeText(LoginPage.this, "Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
            
        } else {
            eName = findViewById(R.id.loginEdtxt1);
            ePassword = findViewById(R.id.loginEdtxt2);
        */

        if (database != null) {
            eID = findViewById(R.id.idText);
            ePassword = findViewById(R.id.loginEdtxt2);
            eLogin = findViewById(R.id.loginBtn);

            String inputID = eID.getText().toString();
            String inputPassword = ePassword.getText().toString();

            // If either ID or Password is missing
            if (inputID.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(LoginPage.this, "Too empty buddy, try again!", Toast.LENGTH_SHORT).show();
            }
            else {
                // Validate user profile from the database
                if (validateUser(inputID, inputPassword)) {
                    Toast.makeText(LoginPage.this, "Welcome " + inputID + " !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginPage.this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginPage.this, "Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
        }
        else {
            eID = findViewById(R.id.loginEdtxt1);
            ePassword = findViewById(R.id.loginEdtxt2);

            String inputName = eID.getText().toString();
            String inputPassword = ePassword.getText().toString();

            // If either ID or Password is missing
            if (inputName.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(LoginPage.this, "Too empty buddy, try again!", Toast.LENGTH_SHORT).show();
            }
            // Invalid account
            else {
                Toast.makeText(LoginPage.this, "Account doesn't exist!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean validateUser(String id, String password) {
        boolean result = false;

        if (database.checkUser(id)) {
            Toast.makeText(this, "Insertion is working", Toast.LENGTH_SHORT).show();
        //if (database.checkUser(id)) {
            User user = database.getUser(id);
            if (password.equals(user.getPassword())) {
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                result = true;
            }
        }
        return result;
    }

    public void onClickCreateAccountButton(View view) {
        Toast.makeText(this, "Create Account Button pressed!", Toast.LENGTH_LONG).show();
        // Brief message
        // Shows create account page
        /* Toast.makeText(this, "Create Account Button pressed!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);*/

        //ConnectDB db = new ConnectDB(Main.getDBPathName());
    }
}
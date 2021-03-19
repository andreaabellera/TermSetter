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
import java.sql.SQLException;

import comp3350.termsetter.Logic.AccessStudents;
import comp3350.termsetter.Persistence.ConnectDB;
import comp3350.termsetter.Persistence.DBImporter;
import comp3350.termsetter.Persistence.DomainSpecific.hsqldbObjects.StudentAccess;
import comp3350.termsetter.Persistence.Main;
import comp3350.termsetter.Persistence.DomainSpecific.StubDatabase;
import comp3350.termsetter.Persistence.UserPersistence;
import comp3350.termsetter.R;

import comp3350.termsetter.Persistence.DomainSpecific.User;

public class LoginPage extends AppCompatActivity {
    private static Context mContext;
    private UserPersistence database;
    private EditText eID;
    private EditText ePassword;
    private Button eLogin;
    private AccessStudents accessStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        try {
            DBImporter.copyDatabaseToDevice(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mContext = getApplicationContext();
        //database = new StubDatabase(mContext,"test.db");

        accessStudents = new AccessStudents();
        database = accessStudents.getStudentPersistence();
    }

    public void onClickLoginButton(View view) throws SQLException {
        if (database != null) {
            eID = findViewById(R.id.loginEdtxt1);
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
                    database.setCurrentUser(inputID);

                    User test = accessStudents.getStudent(inputID);

                    System.out.println(test.getStudentID());

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

            String inputID = eID.getText().toString();
            String inputPassword = ePassword.getText().toString();

            // If either ID or Password is missing
            if (inputID.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(LoginPage.this, "Too empty buddy, try again!", Toast.LENGTH_SHORT).show();
            }
            // Invalid account
            else {
                Toast.makeText(LoginPage.this, "Account doesn't exist!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean validateUser(String id, String password) throws SQLException {
        boolean result = false;
        User user = accessStudents.getStudent(id);

        if (user != null) {
            if (password.equals(user.getPassword())) {
                result = true;
            }
        }
        return result;
    }

    public void onClickCreateAccountButton(View view) throws SQLException {
        // Brief message
        // Shows create account page
        Toast.makeText(this, "Create Account Button pressed!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);

        //ConnectDB db = new ConnectDB(Main.getDBPathName());
        /*StudentAccess db = new StudentAccess(Main.getDBPathName());

        User eriq = db.getUser("hamptone");
        System.out.println(eriq.getName());*/

    }
}
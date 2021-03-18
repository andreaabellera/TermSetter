package comp3350.termsetter.Presentation;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.termsetter.Persistence.DomainSpecific.StubDatabase;
import comp3350.termsetter.R;

import comp3350.termsetter.Persistence.DomainSpecific.Database;
import comp3350.termsetter.Persistence.DomainSpecific.User;
import comp3350.termsetter.Presentation.LoginPage;

public class CreateAccount extends AppCompatActivity {
    private static Context mContext;
    private StubDatabase database;

    private EditText eName;
    private EditText eMail;
    private EditText ePassword;
    private EditText eConfirmPassword;
    private EditText ePhone;
    private EditText eStudentID;
    private Button eCreate;
    private final int idCount = 0;

    public static boolean validate(String name, String password, String email, String confirmPassword, String phone, String studentID) {
        boolean validPassword = password.equals(confirmPassword);
        boolean validName = name.length() <= 20;
        boolean validEmail = email.contains("@myumanitoba.ca");
        boolean validPhone = phone.length() <= 10;
        boolean validStudentID = studentID.length() <= 10;

        if (validPassword && validName && validEmail && validPhone && validStudentID) {
            return true;
        }

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mContext = getApplicationContext();
        database = new StubDatabase(mContext,"test.db");

        eName = findViewById(R.id.loginEdtxt1);
        eMail = findViewById(R.id.createAccountEdtxt4);
        ePassword = findViewById(R.id.loginEdtxt2);
        eConfirmPassword = findViewById(R.id.createAccountEdtxt3);
        ePhone = findViewById(R.id.createAccountEdtxt5);
        eStudentID = findViewById(R.id.studenIDtext);
    }

    public void onClickConfirmButton(View view) {
        String inputID = eStudentID.getText().toString();
        String inputPassword = ePassword.getText().toString();
        String inputEmail = eMail.getText().toString();
        String inputConfirmPassword = eConfirmPassword.getText().toString();
        String inputPhone = ePhone.getText().toString();
        String inputName = eName.getText().toString();

        // If either ID or Password is empty
        if (inputID.isEmpty() || inputPassword.isEmpty()) {
            Toast.makeText(CreateAccount.this, "Too empty buddy, try again!", Toast.LENGTH_SHORT).show();
        }
        else {
            if (validate(inputName, inputPassword, inputEmail, inputConfirmPassword, inputPhone, inputID)) {
                User user = new User(inputName, inputPassword, inputEmail, inputPhone, inputID);
                database.insertUser(user);
                Intent intent = new Intent(CreateAccount.this, LoginPage.class);
                startActivity(intent);
                Toast.makeText(CreateAccount.this, "Welcome " + inputName + "!", Toast.LENGTH_SHORT).show();
            }
        }
    }

}

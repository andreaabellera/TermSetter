package comp3350.termsetter.Persistence;


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

    boolean validate;
    private EditText eName;
    private EditText eMail;
    private EditText ePassword;
    private EditText eConfirmPassword;
    private EditText ePhone;
    private EditText eStudentID;
    private Button eCreate;
    private final int idCount = 0;

    public static boolean validate(String name, String password, String email, String confirmPassword, String phone, String studentID) {
        boolean result = false;
        boolean validPassword = password.equals(confirmPassword);
        boolean validName = name.length() <= 20;
        boolean validEmail = email.contains("@myumanitoba.ca");
        boolean validPhone = phone.length() <= 10;
        boolean validStudentID = studentID.length() <= 10;

        if (validPassword && validName && validEmail && validPhone) {
            result = true;
        }
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_account);

        mContext = getApplicationContext();
        database = new StubDatabase(mContext,"test.db");
        eName = findViewById(R.id.idText);
        eMail = findViewById(R.id.emailText);
        ePassword = findViewById(R.id.passwordText);
        eConfirmPassword = findViewById(R.id.confirmPasswordText);
        ePhone = findViewById(R.id.phoneText);
        eStudentID = findViewById(R.id.studenIDtext);
    }

    public void onClickConfirmButton(View view) {
        String inputName = eName.getText().toString();
        String inputPassword = ePassword.getText().toString();
        String inputEmail = eMail.getText().toString();
        String inputConfirmPassword = eConfirmPassword.getText().toString();
        String inputPhone = ePhone.getText().toString();
        String inputID = eStudentID.getText().toString();

        if (inputName.isEmpty() || inputPassword.isEmpty()) {
            Toast.makeText(CreateAccount.this, "Too empty buddy, try again!", Toast.LENGTH_SHORT).show();
        } else {
            validate = validate(inputName, inputPassword, inputEmail, inputConfirmPassword, inputPhone, inputID);
            if (validate) {
                User user = new User(inputName, inputPassword, inputEmail, inputPhone, inputID);
                database.insert(user);

                if (database.checkUser(inputID)) {
                    Toast.makeText(CreateAccount.this, "Insertion is working", Toast.LENGTH_SHORT).show();

                    User user1 = database.getUser(inputID);
                    if (inputPassword.equals(user1.getPassword())) {
                        Toast.makeText(CreateAccount.this, "Password is correct!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(CreateAccount.this, "WRONG password!", Toast.LENGTH_SHORT).show();
                    }
                }

                Toast.makeText(CreateAccount.this, "Welcome " + inputName + " !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CreateAccount.this, LoginPage.class);
                startActivity(intent);
            }
        }
    }

}

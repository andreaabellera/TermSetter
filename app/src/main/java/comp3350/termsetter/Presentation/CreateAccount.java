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
import comp3350.termsetter.Persistence.DomainSpecific.User;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mContext = getApplicationContext();
        database = new StubDatabase(mContext,"test.db");

        eName = findViewById(R.id.loginEdtxt0);
        eStudentID = findViewById(R.id.loginEdtxt1);
        ePassword = findViewById(R.id.loginEdtxt2);
        eConfirmPassword = findViewById(R.id.createAccountEdtxt3);
        eMail = findViewById(R.id.createAccountEdtxt4);
        ePhone = findViewById(R.id.createAccountEdtxt5);
    }

    public static boolean validate(String name, String id, String password, String confirmPassword, String email, String phone) {
        if(name.isEmpty() || !(name.length() <= 30)){
            Toast.makeText(mContext, "The length of name can be up to 30 characters.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(id.isEmpty() || !(id.length() <= 20)){
            Toast.makeText(mContext, "Your student ID can be up to 20 characters.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password.isEmpty()){
            Toast.makeText(mContext, "Please check password again!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(confirmPassword.isEmpty() || !(confirmPassword.equals(password))){
            Toast.makeText(mContext, "Please check confirm password again!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(email.isEmpty() || !(email.contains("@myumanitoba.ca")) || !(email.length() > "@myumanitoba.ca".length())){
            Toast.makeText(mContext, "Your email domain should contain @myumanitoba.ca and some strings in front.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(phone.isEmpty() || !(phone.length() == 10)){
            Toast.makeText(mContext, "Your phone number has to be exactly 10 numbers.", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }

    public void onClickConfirmButton(View view) {
        String inputName = eName.getText().toString();
        String inputID = eStudentID.getText().toString();
        String inputPassword = ePassword.getText().toString();
        String inputConfirmPassword = eConfirmPassword.getText().toString();
        String inputEmail = eMail.getText().toString();
        String inputPhone = ePhone.getText().toString();

        if (validate(inputName, inputID, inputPassword, inputConfirmPassword, inputEmail, inputPhone)) {
            User user = new User(inputName, inputPassword, inputEmail, inputPhone, inputID);
            database.insertUser(user);
            Intent intent = new Intent(CreateAccount.this, LoginPage.class);

            startActivity(intent);
            Toast.makeText(CreateAccount.this, "Welcome " + inputName + "!", Toast.LENGTH_SHORT).show();
        }

    }

}

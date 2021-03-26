package comp3350.termsetter.Presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLException;

import comp3350.termsetter.Logic.AccessStudents;
import comp3350.termsetter.Logic.AccountValidation;
import comp3350.termsetter.Persistence.UserPersistence;
import comp3350.termsetter.R;
import comp3350.termsetter.Persistence.DomainSpecific.Student;

public class CreateAccount extends AppCompatActivity {
    private static Context mContext;
    private StudentPersistence database;
    private AccountValidation accountValidation;
    private EditText eName;
    private EditText eMail;
    private EditText ePassword;
    private EditText eConfirmPassword;
    private EditText ePhone;
    private EditText eStudentID;
    private Button eCreate;
    private final int idCount = 0;

    private AccessStudents accessStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mContext = getApplicationContext();
        //database = new StubDatabase(mContext,"test.db");
        //database = new StudentAccess("users.db");

        accessStudents = new AccessStudents();
        database = accessStudents.getStudentPersistence();

        eName = findViewById(R.id.editTextSetName);
        eStudentID = findViewById(R.id.editTextSetID);
        ePassword = findViewById(R.id.editTextSetPassword);
        eConfirmPassword = findViewById(R.id.editTextConfirmAPassword);
        eMail = findViewById(R.id.editTextEmail);
        ePhone = findViewById(R.id.editTextPhone);
    }

    public boolean validate(String name, String id, String password, String confirmPassword, String email, String phone) {

        accountValidation = new AccountValidation();

        // 1. Check Name
        boolean validName = accountValidation.validName(name);
        if (!validName) {
            Toast.makeText(mContext, "The name consist of First name, 1 whitespace, and Last name.", Toast.LENGTH_SHORT).show();
            return false;
        }

        // 2. Check ID (must start with a character, then some numbers)
        boolean validID = accountValidation.validID(id);
        if (!validID) {
            Toast.makeText(mContext, "Your student ID must begin with a character.", Toast.LENGTH_SHORT).show();
            return false;
        }

        // 3. Check password
        boolean validPassword = accountValidation.validPassword(password);
        if (!validPassword) {
            Toast.makeText(mContext, "Password must be 10 characters long and contain both letter and number!", Toast.LENGTH_SHORT).show();
            return false;
        }

        // 4. Check confirm password
        boolean validConfirmPassword = accountValidation.validPassword(confirmPassword);
        if(!validPassword || !(accountValidation.confirmPassword(password, confirmPassword))){
            Toast.makeText(mContext, "Please check confirm password again!", Toast.LENGTH_SHORT).show();
            return false;
        }
        // 5. Check email

        boolean validEmail = accountValidation.validEmail(email);
        if (!validEmail) {
            Toast.makeText(mContext, "Your email domain should contain @myumanitoba.ca and some strings in front.", Toast.LENGTH_SHORT).show();
            return false;
        }

        // 6. Check phone number (guaranteed to be just number)
        boolean validPhone = accountValidation.validPhone(phone);
        if(!validPhone){
            Toast.makeText(mContext, "Your phone number has to be exactly 10 numbers.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void onClickConfirmButton(View view) throws SQLException {
        String inputName = eName.getText().toString();
        String inputID = eStudentID.getText().toString();
        String inputPassword = ePassword.getText().toString();
        String inputConfirmPassword = eConfirmPassword.getText().toString();
        String inputEmail = eMail.getText().toString();
        String inputPhone = ePhone.getText().toString();

        if (validate(inputName, inputID, inputPassword, inputConfirmPassword, inputEmail, inputPhone)) {
           Student student = new Student(inputName, inputPassword, inputEmail, inputPhone,inputID);
            //database.insertUser(user);
//            Intent intent = new Intent(CreateAccount.this, LoginPage.class);
//            startActivity(intent);
//            Toast.makeText(CreateAccount.this, "Welcome " + inputName + "!", Toast.LENGTH_SHORT).show();

            accessStudents.insertStudent(student);

            Student test = accessStudents.getStudent(inputID);

            System.out.println(test.getStudentID());

            Intent intent = new Intent(CreateAccount.this, LoginPage.class);

            startActivity(intent);
            Toast.makeText(CreateAccount.this, "Welcome " + inputName + "!", Toast.LENGTH_SHORT).show();
        }

    }

}

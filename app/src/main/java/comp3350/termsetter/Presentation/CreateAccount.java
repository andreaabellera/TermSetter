package comp3350.termsetter.Presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import comp3350.termsetter.Logic.AccessManager;
import comp3350.termsetter.Logic.AccountValidation;
import comp3350.termsetter.Persistence.DomainSpecific.Student;
import comp3350.termsetter.Persistence.StudentPersistence;
import comp3350.termsetter.R;

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

    private AccessManager accessManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mContext = getApplicationContext();
        //database = new StubDatabase(mContext,"test.db");
        //database = new StudentAccess("users.db");

        accessManager = new AccessManager();
        database = accessManager.getStudentPersistence();

        eName = findViewById(R.id.editTextSetName);
        eStudentID = findViewById(R.id.editTextSetID);
        ePassword = findViewById(R.id.editTextSetPassword);
        eConfirmPassword = findViewById(R.id.editTextConfirmAPassword);
        eMail = findViewById(R.id.editTextEmail);
        ePhone = findViewById(R.id.editTextPhone);
    }

    public boolean isValidAccount(String name, String id, String password, String confirmPassword, String email, String phone) {

        accountValidation = new AccountValidation();

        // 1. Check Name
        boolean validName = accountValidation.validName(name);
        if (!validName) {
            eName.setError("Name is blank, or contains invalid symbols.",null);
            //Toast.makeText(mContext, "The name should consist of Uppercase or lowercase characters only.", Toast.LENGTH_SHORT).show();
            return false;
        }

        // 2. Check ID (must start with a character, then some numbers)
        boolean validID = accountValidation.validID(id);
        if (!validID) {
            eStudentID.setError("ID must begin with a letter.",null);
            //Toast.makeText(mContext, "Your student ID must begin with a character.", Toast.LENGTH_SHORT).show();
            return false;
        }

        // 3. Check password
        boolean validPassword = accountValidation.validPassword(password);
        if (!validPassword) {
            ePassword.setError("Password invalid");
            //Toast.makeText(mContext, "Password should have minimum length of 6, starts with a letter, and consist of at least one letter and number!", Toast.LENGTH_SHORT).show();
            return false;
        }

        // 4. Check confirm password
        boolean validConfirmPassword = accountValidation.validPassword(confirmPassword);
        if(!validConfirmPassword){
            eConfirmPassword.setError("Entry does not match password.");
            //Toast.makeText(mContext, "Please check confirm password again!", Toast.LENGTH_SHORT).show();
            return false;
        }

        // 5. Check email
        boolean validEmail = accountValidation.validEmail(email);
        if (!validEmail) {
            eMail.setError("Invalid email.");
            //Toast.makeText(mContext, "Your email domain should contain @myumanitoba.ca and some strings in front.", Toast.LENGTH_SHORT).show();
            return false;
        }

        // 6. Check phone number (guaranteed to be just number)
        boolean validPhone = accountValidation.validPhone(phone);
        if(!validPhone){
            ePhone.setError("Invalid phone number");
            //Toast.makeText(mContext, "Please provide phone number (without dashes) as XXXYYYZZZZ format.", Toast.LENGTH_SHORT).show();
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

        if (isValidAccount(inputName, inputID, inputPassword, inputConfirmPassword, inputEmail, inputPhone)) {
           Student student = new Student(inputName, inputPassword, inputEmail, inputPhone,inputID);
            accessManager.insertStudent(student);
            Student test = accessManager.getStudent(inputID);

            System.out.println(test.getStudentID());

            Intent intent = new Intent(CreateAccount.this, LoginPage.class);
            startActivity(intent);
            Toast.makeText(CreateAccount.this, "Welcome " + inputName + "!", Toast.LENGTH_SHORT).show();
        }

    }

}

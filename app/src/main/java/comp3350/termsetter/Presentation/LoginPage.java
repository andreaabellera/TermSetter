package comp3350.termsetter.Presentation;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.termsetter.R;

import comp3350.termsetter.Persistence.CreateAccount;
import comp3350.termsetter.Persistence.DomainSpecific.Database;
import comp3350.termsetter.Persistence.DomainSpecific.User;

public class LoginPage extends AppCompatActivity {


    boolean validate;
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }

    public void onClickLoginButton(View view) {
        Intent intent = getIntent();
        Database database = (Database) intent.getSerializableExtra("database");

        if (database != null) {
            boolean noUserExist = database.isEmpty();
            if (!noUserExist) {
                eName = findViewById(R.id.login_edtxt_id);
                ePassword = findViewById(R.id.login_edtxt_pw);
                eLogin = findViewById(R.id.login_btn_login);

                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(LoginPage.this, "Too empty buddy, try again!", Toast.LENGTH_SHORT).show();
                } else {
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
            }
        } else {
            eName = findViewById(R.id.login_edtxt_id);
            ePassword = findViewById(R.id.login_edtxt_pw);

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
        Intent intent = getIntent();
        Database database = (Database) intent.getSerializableExtra("database");
        User user = database.getUser();
        boolean result = false;
        if (name.equals(user.getName()) && password.equals(user.getPassword())) {
            result = true;
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
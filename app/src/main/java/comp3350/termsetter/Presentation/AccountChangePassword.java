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

public class AccountChangePassword extends AppCompatActivity {
    private static Context mContext;
    private StubDatabase database;
    private boolean validate;
    private EditText oldPassword;
    private EditText newPassword;
    private EditText newPasswordConfirm;
    private User user;
    private Button change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_change_password);

        mContext = getApplicationContext();
        database = new StubDatabase(mContext,"test.db");
    }


    public void onClickConfirmButton(View view) {
        oldPassword = findViewById(R.id.changePasswordEdtxt1);
        newPassword = findViewById(R.id.changePasswordEdtxt2);
        newPasswordConfirm = findViewById(R.id.changePasswordEdtxt3);

        String inputOldPassword = oldPassword.getText().toString();
        String inputNewPassword = newPassword.getText().toString();
        String inputNewPasswordConfirm = newPasswordConfirm.getText().toString();

        if (inputOldPassword.isEmpty() || inputNewPassword.isEmpty() || inputNewPasswordConfirm.isEmpty()) {
            Toast.makeText(AccountChangePassword.this, "Too empty buddy, try again!", Toast.LENGTH_SHORT).show();
        } else {
            if (validate(inputOldPassword, inputNewPassword, inputNewPasswordConfirm)) {
                Toast.makeText(AccountChangePassword.this, "Old Password: " + inputOldPassword, Toast.LENGTH_SHORT).show();
                Toast.makeText(AccountChangePassword.this, "New Password: " + inputNewPassword, Toast.LENGTH_SHORT).show();
                Toast.makeText(AccountChangePassword.this, "Confirm Password: " + inputNewPasswordConfirm, Toast.LENGTH_SHORT).show();

                if (database.updatePassword(inputNewPassword)) {
                    Toast.makeText(AccountChangePassword.this, "Password has been changed!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AccountChangePassword.this, AccountManagementMenu.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(AccountChangePassword.this, "Update password is not working!", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(AccountChangePassword.this, "Please try again!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean validate(String oldPass, String newPass, String newPassConfirm) {
        User user = database.getCurrentUser();
        boolean result = false;

        if (oldPass.equals(user.getPassword())) {
            if (newPass.equals(newPassConfirm)) {
                result = true;
            }
            else {
                Toast.makeText(AccountChangePassword.this, "Please confirm your password again!", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(AccountChangePassword.this, "Your old password is incorrect!", Toast.LENGTH_SHORT).show();
        }
        return result;
    }
}
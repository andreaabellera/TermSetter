package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

    public class AccountUpdateEmail extends AppCompatActivity {
        private EditText newEmail = findViewById(R.id.update_email_input1);
        private EditText newEmailConfirm = findViewById(R.id.update_email_input2);
        private Button change = findViewById(R.id.btn_confirm);
        boolean validate;

        Intent intent = getIntent();
        Database database = (Database)intent.getSerializableExtra("database");

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_account_change_password);

            change.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = getIntent();
                    Database database = (Database)intent.getSerializableExtra("database");


                    String inputNewEmail = newEmail.getText().toString();
                    String inputNewEmailConfirm = newEmailConfirm.getText().toString();

                    if (inputNewEmail.isEmpty() || inputNewEmailConfirm.isEmpty()) {
                        Toast.makeText(AccountUpdateEmail.this, "Too empty buddy, try again!", Toast.LENGTH_SHORT).show();
                    } else {
                        validate = validate(inputNewEmail, inputNewEmailConfirm);
                        if (validate) {
                            Toast.makeText(AccountUpdateEmail.this, "Password changes!", Toast.LENGTH_SHORT).show();
                            Intent intentI = new Intent(AccountUpdateEmail.this, AccountManagementMenu.class);
                            intentI.putExtra("database", database);
                            startActivity(intentI);
                        } else {
                            Toast.makeText(AccountUpdateEmail.this, "Please try again!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }

        private boolean validate(String newEmail, String newEmailConfirm) {
            boolean result = false;
            if (newEmail.equals(newEmailConfirm)) {
                result = true;
            }
            return result;
        }
    }
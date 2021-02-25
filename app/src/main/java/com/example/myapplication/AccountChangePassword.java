package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AccountChangePassword extends AppCompatActivity {

    private String currPw; // should be a variable belonging to a user/student class

    private String inputCurrPw;
    private String inputNewPw;
    private String inputNewPwConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_change_password);
    }

    public void confirmChange(){
        // validate current password
            // input = currPassword

        // validate new password
            // not null
            // different from current
            // ! ask about password requirements (eg. 8 chars, 1 num, 1owercase, uppercase?)

        // validate confirm
            // confirm = new password

        // if all^
            //currPw = new Pw
    }
}
package comp3350.termsetter.Presentation;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.termsetter.R;

import comp3350.termsetter.Persistence.DomainSpecific.Database;

public class AccountManagementMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_management_menu);
    }

    public void openManageProfile(View view) {
        Intent intent = new Intent(this, AccountManageProfile.class);
        startActivity(intent);
    }

    public void openUpdateEmail(View view) {
        Intent intent = getIntent();
        Database database = (Database) intent.getSerializableExtra("database");
        Intent intentI = new Intent(this, comp3350.termsetter.Presentation.AccountUpdateEmail.class);
        intentI.putExtra("database", database);
        startActivity(intentI);
    }

    public void openChangePassword(View view) {
        Intent intent = getIntent();
        Database database = (Database) intent.getSerializableExtra("database");
        Intent intentI = new Intent(this, comp3350.termsetter.Presentation.AccountChangePassword.class);
        intentI.putExtra("database", database);
        startActivity(intentI);
    }

    public void openSettings(View view) {
        Intent intent = new Intent(this, comp3350.termsetter.Presentation.AccountSettings.class);
        startActivity(intent);
    }
}
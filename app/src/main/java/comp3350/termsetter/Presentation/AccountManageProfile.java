package comp3350.termsetter.Presentation;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLException;

import comp3350.termsetter.Persistence.DomainSpecific.StubDatabase;
import comp3350.termsetter.Persistence.DomainSpecific.User;
import comp3350.termsetter.Persistence.UserPersistence;
import comp3350.termsetter.R;

public class AccountManageProfile extends AppCompatActivity {
    private static Context mContext;
    private UserPersistence database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_manage_profile2);

        mContext = getApplicationContext();
        database = new StubDatabase(mContext,"test.db");
        try {
            displayProfile();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void displayProfile() throws SQLException {
        User user = database.getCurrentUser();

        TextView studentName = findViewById(R.id.manageProfileTxtStudent2);
        TextView studentID = findViewById(R.id.manageProfileTxtStudent3);
        TextView studentEmail = findViewById(R.id.manageProfileTxtStudent4);
        TextView studentPhone = findViewById(R.id.manageProfileTxtStudent5);

        studentName.setText(user.getName());
        studentID.setText(user.getStudentID());
        studentEmail.setText(user.getEmailAddress());
        studentPhone.setText(user.getPhoneNumber());
    }
}
package comp3350.termsetter.Presentation;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.SQLException;
import comp3350.termsetter.Logic.AccessStudents;
import comp3350.termsetter.Persistence.DomainSpecific.Student;
import comp3350.termsetter.Persistence.StudentPersistence;
import comp3350.termsetter.R;

public class AccountManageProfile extends AppCompatActivity {
    private static Context mContext;
    private StudentPersistence database;
    private AccessStudents accessStudents;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_manage_profile2);

        mContext = getApplicationContext();
       // database = new StubDatabase(mContext,"test.db");
        accessStudents = new AccessStudents();
        database = accessStudents.getStudentPersistence();
        try {
            displayProfile();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void displayProfile() throws SQLException {
        Student student = database.getCurrentStudentID();
        //User user = accessStudents.getStudent("asdf");

        TextView studentName = findViewById(R.id.userInfoName);
        TextView studentID = findViewById(R.id.userInfoStudentID);
        TextView studentEmail = findViewById(R.id.userInfoEmail);
        TextView studentPhone = findViewById(R.id.userInfoPhone);

        studentName.setText(student.getName());
        studentID.setText(student.getStudentID());
        studentEmail.setText(student.getEmailAddress());
        studentPhone.setText(student.getPhoneNumber());
    }
}


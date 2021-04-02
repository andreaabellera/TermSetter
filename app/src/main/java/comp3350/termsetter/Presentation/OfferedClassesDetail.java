package comp3350.termsetter.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import comp3350.termsetter.Logic.AccessManager;
import comp3350.termsetter.Logic.EnrollmentLogic;
import comp3350.termsetter.Persistence.CourseOffering;
import comp3350.termsetter.Persistence.CourseSection;
import comp3350.termsetter.Persistence.DomainSpecific.Student;
import comp3350.termsetter.Persistence.StudentPersistence;
import comp3350.termsetter.R;

public class OfferedClassesDetail extends AppCompatActivity {

    CourseOffering course;
    EnrollmentLogic eL;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offered_classes_detail);
        initData();
        initWidgets();
    }

    private void initData(){
        AccessManager accessManager = new AccessManager();
        StudentPersistence database = accessManager.getStudentPersistence();
        student = database.getCurrentStudentID();
    }

    private void initWidgets() {
        course = (CourseOffering) getIntent().getSerializableExtra("course");
        TextView selectedClass = findViewById(R.id.headerCourseCode);
        selectedClass.setText(course.getCourseCode());
        TextView selectedClassName = findViewById(R.id.headerCourseName);
        selectedClassName.setText(course.getName());
        TextView selectedClassCred = findViewById(R.id.textCourseCredits);
        selectedClassCred.setText(course.getCreditHours() + ".00CR");
    }

    public void openCategories(View view) {
        String section = "";
        String timeSlot = "";
        String days = "";
        String period = "";
        int s1_id = getResources().getIdentifier("radioButtonS1", "id", getPackageName());
        RadioGroup rg = findViewById(R.id.radioGroupSections);
        if (rg.getCheckedRadioButtonId() == s1_id) {
            TextView sectionTxt = findViewById(R.id.radioButtonS1);
            section = (String) sectionTxt.getText();
            TextView timeSlotTxt = findViewById(R.id.textS1Time);
            timeSlot = (String) timeSlotTxt.getText();
            TextView daysTxt = findViewById(R.id.textS1Days);
            days = (String) daysTxt.getText();
            TextView periodTxt = findViewById(R.id.textS1Instructor);
            period = (String) periodTxt.getText();
        } else {
            TextView sectionTxt = findViewById(R.id.radioButtonS2);
            section = (String) sectionTxt.getText();
            TextView timeSlotTxt = findViewById(R.id.textS2Time);
            timeSlot = (String) timeSlotTxt.getText();
            TextView daysTxt = findViewById(R.id.textS2Days);
            days = (String) daysTxt.getText();
            TextView periodTxt = findViewById(R.id.textS2Instructor);
            period = (String) periodTxt.getText();
        }

        CourseSection theSection = new CourseSection(section, days, timeSlot, period);
        eL = new EnrollmentLogic(student.getStudentID(), course.getCourseCode(), theSection);
        String message = eL.getMessage();

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, OfferedClassesCategories.class);
        startActivity(intent);
    }

}
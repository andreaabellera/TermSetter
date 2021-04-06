package comp3350.termsetter.Presentation;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import comp3350.termsetter.Logic.AccessManager;
import comp3350.termsetter.Persistence.CourseOffering;
import comp3350.termsetter.Persistence.CourseSection;
import comp3350.termsetter.Persistence.DomainSpecific.Student;
import comp3350.termsetter.Persistence.DomainSpecific.hsqldbObjects.EnrollAccess;
import comp3350.termsetter.Persistence.Main;
import comp3350.termsetter.Persistence.StudentPersistence;
import comp3350.termsetter.R;
import comp3350.termsetter.UIAdapters.RecyclerCurrClassDataAdapter;

public class EnrolledClassesView extends AppCompatActivity {

    List<CourseOffering> enrolledCourses;
    List<CourseSection> enrolledSections;
    EnrollAccess enrollAccess;
    Student student;
    RecyclerCurrClassDataAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrolled_classes_view);
        initData();
        initWidgets();
        updateTotal();
    }

    private void initData(){
        enrolledCourses = new ArrayList<>();
        enrolledSections = new ArrayList<>();

        AccessManager accessManager = new AccessManager();
        StudentPersistence database = accessManager.getStudentPersistence();
        student = database.getCurrentStudentID();

        String path = Main.getDBPathName();
        enrollAccess = new EnrollAccess(path);

        List<String> results = enrollAccess.getStudentEnrollment(student.getStudentID());

        for(int i = 0; i < results.size(); i++)
        {
            String result = results.get(i);
            String[] tokens = result.split("@");
            CourseOffering currCourse = new CourseOffering(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            enrolledCourses.add(currCourse);
            CourseSection currClass = new CourseSection(tokens[3], tokens[4], tokens[5], tokens[6]);
            enrolledSections.add(currClass);
        }
    }

    private void initWidgets(){
        RecyclerView classes = (RecyclerView)findViewById(R.id.recycleEnrolledClasses);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        classes.setLayoutManager(layoutManager);
        recyclerAdapter= new RecyclerCurrClassDataAdapter(enrolledCourses, enrolledSections);
        classes.setAdapter(recyclerAdapter);
    }

    private void updateTotal(){
        double total = 562.12 * recyclerAdapter.getItemCount();
        total = Math.round(total * 100.0) / 100.0;  // reduces to 2 decimal places
        TextView total_txt = (TextView) findViewById(R.id.textFeeTotal);
        total_txt.setText("Total Fees: " + Double.toString(total)+" CAD");
    }



}
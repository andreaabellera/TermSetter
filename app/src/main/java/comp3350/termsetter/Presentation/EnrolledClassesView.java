package comp3350.termsetter.Presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import comp3350.termsetter.Persistence.CourseOffering;
import comp3350.termsetter.Persistence.CourseSection;
import comp3350.termsetter.R;
import comp3350.termsetter.UIAdapters.RecyclerCurrClassDataAdapter;

public class EnrolledClassesView extends AppCompatActivity {

    List<CourseOffering> enrolledCourses;
    List<CourseSection> enrolledSections;
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

        enrolledCourses.add(new CourseOffering("COMP3010", "Distributed Computing", 3));
        enrolledSections.add(new CourseSection("A01", "MWF", "11:30-12:20","2021/01/18-2021/04/18"));

        enrolledCourses.add(new CourseOffering("MUSC1180", "Ensemble", 2));
        enrolledSections.add(new CourseSection("A02", "TR", "10:30-11:45","2021/01/18-2021/04/18"));
    }

    private void initWidgets(){
        RecyclerView classes = (RecyclerView)findViewById(R.id.enrolled_classes_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        classes.setLayoutManager(layoutManager);
        recyclerAdapter= new RecyclerCurrClassDataAdapter(enrolledCourses, enrolledSections);
        classes.setAdapter(recyclerAdapter);
    }

    private void updateTotal(){
        double total = 562.12 * recyclerAdapter.getItemCount();
        TextView total_txt = (TextView) findViewById(R.id.total_txt);
        total_txt.setText("Total Fees: " + Double.toString(total)+" CAD");
    }



}
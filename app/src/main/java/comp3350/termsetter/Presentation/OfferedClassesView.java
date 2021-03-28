package comp3350.termsetter.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import comp3350.termsetter.UIAdapters.RecyclerCourseDataAdapter;
import comp3350.termsetter.Persistence.CourseOffering;
import comp3350.termsetter.Persistence.Faculty;
import comp3350.termsetter.R;

public class OfferedClassesView extends AppCompatActivity {

    Faculty faculty;
    List<CourseOffering> lv1Courses;
    List<CourseOffering> lv2Courses;
    List<CourseOffering> lv3Courses;
    List<CourseOffering> lv4Courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offered_classes_view);
        initData();
        initWidgets();
    }

    private void initData(){
        faculty = (Faculty) getIntent().getSerializableExtra("faculty");
        TextView selectedCategory = findViewById(R.id.headerDepartment);
        selectedCategory.setText(faculty.getName());
        lv1Courses = faculty.getCoursesByLevel(1);
        lv2Courses = faculty.getCoursesByLevel(2);
        lv3Courses = faculty.getCoursesByLevel(3);
        lv4Courses = faculty.getCoursesByLevel(4);
    }

    private void initWidgets() {
        RecyclerView lv1 = (RecyclerView)findViewById(R.id.recycleViewLevel1);
        RecyclerView lv2 = (RecyclerView)findViewById(R.id.recyleViewLevel2);
        RecyclerView lv3 = (RecyclerView)findViewById(R.id.recyleViewLevel3);
        RecyclerView lv4 = (RecyclerView)findViewById(R.id.recycleViewLevel4);

        GridLayoutManager layoutManager1 = new GridLayoutManager(this,1);
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        lv1.setLayoutManager(layoutManager1);
        GridLayoutManager layoutManager2 = new GridLayoutManager(this,1);
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        lv2.setLayoutManager(layoutManager2);
        GridLayoutManager layoutManager3 = new GridLayoutManager(this,1);
        layoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        lv3.setLayoutManager(layoutManager3);
        GridLayoutManager layoutManager4 = new GridLayoutManager(this,1);
        layoutManager4.setOrientation(LinearLayoutManager.HORIZONTAL);
        lv4.setLayoutManager(layoutManager4);

        comp3350.termsetter.UIAdapters.RecyclerCourseDataAdapter recyclerAdapter1= new comp3350.termsetter.UIAdapters.RecyclerCourseDataAdapter(lv1Courses,1);
        lv1.setAdapter(recyclerAdapter1);
        recyclerAdapter1.setOnClick(this::onItemClick1);
        comp3350.termsetter.UIAdapters.RecyclerCourseDataAdapter recyclerAdapter2= new comp3350.termsetter.UIAdapters.RecyclerCourseDataAdapter(lv2Courses,2);
        lv2.setAdapter(recyclerAdapter2);
        recyclerAdapter2.setOnClick(this::onItemClick2);
        comp3350.termsetter.UIAdapters.RecyclerCourseDataAdapter recyclerAdapter3= new comp3350.termsetter.UIAdapters.RecyclerCourseDataAdapter(lv3Courses,3);
        lv3.setAdapter(recyclerAdapter3);
        recyclerAdapter3.setOnClick(this::onItemClick3);
        comp3350.termsetter.UIAdapters.RecyclerCourseDataAdapter recyclerAdapter4= new comp3350.termsetter.UIAdapters.RecyclerCourseDataAdapter(lv4Courses,4);
        lv4.setAdapter(recyclerAdapter4);
        recyclerAdapter4.setOnClick(this::onItemClick4);

    }

    public void onItemClick1(int position) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", lv1Courses.get(position));
        startActivity(intent);
    }

    public void onItemClick2(int position) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", lv2Courses.get(position));
        startActivity(intent);
    }

    public void onItemClick3(int position) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", lv3Courses.get(position));
        startActivity(intent);
    }

    public void onItemClick4(int position) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", lv4Courses.get(position));
        startActivity(intent);
    }

}
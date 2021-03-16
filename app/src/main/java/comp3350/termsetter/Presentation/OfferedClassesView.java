package comp3350.termsetter.Presentation;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.termsetter.R;

import comp3350.termsetter.Persistence.Faculty;


public class OfferedClassesView extends AppCompatActivity {

    Faculty faculty;
    int lvCount = 3;
    int btnCount = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offered_classes_view);

        init();
    }

    private void init() {
        faculty = (Faculty) getIntent().getSerializableExtra("faculty");
        TextView selectedCategory = findViewById(R.id.selectedCategory_txt);
        selectedCategory.setText(faculty.getName());

        for (int l = 0; l < lvCount; l++) {
            int lv = l + 1; // must be done explicitly
            for (int i = 0; i < btnCount; i++) {
                int num = i + 1;
                int btnID = getResources().getIdentifier("lv" + lv + "_" + num + "_btn", "id", getPackageName());
                Button button = findViewById(btnID);
                button.setText(faculty.getCourse(i + l * btnCount).getCourseCode());
            }
        }

        /* For under initwidgets
        RecyclerView lv1 = (RecyclerView)findViewById(R.id.lv1_rv);
        RecyclerView lv2 = (RecyclerView)findViewById(R.id.lv2_rv);
        RecyclerView lv3 = (RecyclerView)findViewById(R.id.lv3_rv);
        RecyclerView lv4 = (RecyclerView)findViewById(R.id.lv4_rv);

        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        lv1.setLayoutManager(layoutManager);
        lv2.setLayoutManager(layoutManager);
        lv3.setLayoutManager(layoutManager);
        lv4.setLayoutManager(layoutManager);

        RecyclerViewDataAdapter recyclerAdapter= new RecyclerViewDataAdapter(courseData);
        lv1.setAdapter(recyclerAdapter);
        lv2.setAdapter(recyclerAdapter);
        lv3.setAdapter(recyclerAdapter);
        lv4.setAdapter(recyclerAdapter);
        //lv1.scrollToPosition(0);
         */
    }

    public void openClassDetail0(View view) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", faculty.getCourse(0));
        startActivity(intent);
    }

    public void openClassDetail1(View view) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", faculty.getCourse(1));
        startActivity(intent);
    }

    public void openClassDetail2(View view) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", faculty.getCourse(2));
        startActivity(intent);
    }

    public void openClassDetail3(View view) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", faculty.getCourse(3));
        startActivity(intent);
    }

    public void openClassDetail4(View view) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", faculty.getCourse(4));
        startActivity(intent);
    }

    public void openClassDetail5(View view) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", faculty.getCourse(5));
        startActivity(intent);
    }

    public void openClassDetail6(View view) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", faculty.getCourse(6));
        startActivity(intent);
    }

    public void openClassDetail7(View view) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", faculty.getCourse(7));
        startActivity(intent);
    }

    public void openClassDetail8(View view) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", faculty.getCourse(8));
        startActivity(intent);
    }

    public void openClassDetail9(View view) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", faculty.getCourse(9));
        startActivity(intent);
    }

    public void openClassDetail10(View view) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", faculty.getCourse(10));
        startActivity(intent);
    }

    public void openClassDetail11(View view) {
        Intent intent = new Intent(this, OfferedClassesDetail.class);
        intent.putExtra("course", faculty.getCourse(11));
        startActivity(intent);
    }
}
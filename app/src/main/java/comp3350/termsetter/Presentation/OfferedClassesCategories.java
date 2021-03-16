package comp3350.termsetter.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import comp3350.termsetter.Logic.OfferedClassLogic;
import comp3350.termsetter.Logic.RecyclerViewDataAdapter;
import comp3350.termsetter.Persistence.Faculty;
import comp3350.termsetter.R;
import java.io.InputStream;
import java.util.List;

import comp3350.termsetter.Persistence.CourseCategoryDriver;


public class OfferedClassesCategories extends AppCompatActivity {

    List<Faculty> courseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offered_classes_categories);
        initDB();
        initWidgets();
    }

    private void initDB(){
        try{
            OfferedClassLogic dataRequester = new OfferedClassLogic(false, this);
            courseData = dataRequester.getCourseData();
        }
        catch(Exception e){
            System.out.println("Database load failed.");
            e.printStackTrace();
        }
    }

    private void initWidgets(){
        RecyclerView faculties = (RecyclerView)findViewById(R.id.faculties_rv);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        faculties.setLayoutManager(layoutManager);
        RecyclerViewDataAdapter recyclerAdapter= new RecyclerViewDataAdapter(courseData);
        faculties.setAdapter(recyclerAdapter);
        recyclerAdapter.setOnClick(this::onItemClick);
    }

    public void onItemClick(int position) {
        Intent intent = new Intent(this, OfferedClassesView.class);
        intent.putExtra("faculty", courseData.get(0));
        startActivity(intent);
    }

    public void backToMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

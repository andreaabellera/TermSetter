package comp3350.termsetter.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import comp3350.termsetter.Logic.OfferedClassLogic;
import comp3350.termsetter.Persistence.Faculty;
import comp3350.termsetter.R;
import java.io.InputStream;
import java.util.List;

import comp3350.termsetter.Persistence.CourseCategoryDriver;


public class OfferedClassesCategories extends AppCompatActivity {

    List<Faculty> courseData;
    int btnCount = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offered_classes_categories);
        init();
    }

    public void openClassViewAcc(View view) {
        Intent intent = new Intent(this, OfferedClassesView.class);
        intent.putExtra("faculty", courseData.get(0));
        startActivity(intent);
    }

    public void openClassViewCS(View view) {
        Intent intent = new Intent(this, OfferedClassesView.class);
        intent.putExtra("faculty", courseData.get(1));
        startActivity(intent);
    }

    public void openClassViewMath(View view) {
        Intent intent = new Intent(this, OfferedClassesView.class);
        intent.putExtra("faculty", courseData.get(2));
        startActivity(intent);
    }

    public void openClassViewMIS(View view) {
        Intent intent = new Intent(this, OfferedClassesView.class);
        intent.putExtra("faculty", courseData.get(3));
        startActivity(intent);
    }

    private void init(){
        try{
            OfferedClassLogic dataRequester = new OfferedClassLogic(false, this);
            courseData = dataRequester.getCourseData();

            for(int i = 0; i < btnCount; i++) {
                int num = i + 1; // must be done explicitly
                int btnID = getResources().getIdentifier("category" + num + "_btn", "id", getPackageName());
                Button button = findViewById(btnID);
                button.setText(courseData.get(i).getName());
            }
        }
        catch(Exception e){
            System.out.println("Database load failed.");
            e.printStackTrace();
        }
    }
}

package comp3350.termsetter.UIAdapters;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import comp3350.termsetter.Persistence.CourseOffering;
import comp3350.termsetter.Persistence.CourseSection;
import comp3350.termsetter.R;

public class RecyclerRemoveClassDataAdapter extends RecyclerView.Adapter<RecyclerRemoveClassDataAdapter.ViewHolder> {

    private List<CourseOffering> courseItems;
    private List<CourseSection> sectionItems;
    private RecyclerFacultyDataAdapter.OnItemClicked onClick;

    public RecyclerRemoveClassDataAdapter(List<CourseOffering> courseItems, List<CourseSection> sectionItems) {
        this.courseItems = courseItems;
        this.sectionItems = sectionItems;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView course_id_txt;
        public TextView course_credit_txt;

        public ViewHolder(View v){
            super(v);
            course_id_txt = (TextView)v.findViewById(R.id.course_id);
            course_credit_txt = (TextView)v.findViewById(R.id.course_credit);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Get LayoutInflater object
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.widget_remove_class_recycler_card, parent, false);
        ViewHolder ret = new ViewHolder(itemView);
        return ret;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(courseItems != null && sectionItems != null) {
            CourseOffering courseItem = courseItems.get(position);
            CourseSection sectionItem = sectionItems.get(position);

            if(courseItem != null && sectionItem != null) {
                holder.course_id_txt.setText(courseItem.getCourseCode() + " - " + courseItem.getName());
                holder.course_credit_txt.setText("Credit Hours: " + courseItem.getCreditHours() + ".00 CR");
            }
        }
    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if(courseItems!=null) {
            ret = courseItems.size();
        }
        return ret;
    }

}

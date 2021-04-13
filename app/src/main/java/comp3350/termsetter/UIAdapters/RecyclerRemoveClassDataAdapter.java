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

    public interface OnItemClicked {
        void onItemClick(int position);
    }

    public RecyclerRemoveClassDataAdapter(List<CourseOffering> courseItems, List<CourseSection> sectionItems) {
        this.courseItems = courseItems;
        this.sectionItems = sectionItems;
    }

    public interface btnClickListener {
        void onItemClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView course_id_txt;
        public TextView course_section_txt;
        public CardView cardView;

        public ViewHolder(View v){
            super(v);
            course_id_txt = (TextView)v.findViewById(R.id.course_id);
            course_section_txt = (TextView)v.findViewById(R.id.course_section);
            cardView = (CardView)v.findViewById(R.id.recycler_card);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Get LayoutInflater object.
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Inflate the RecyclerView item layout xml.
        View itemView = layoutInflater.inflate(R.layout.widget_currclass_recycler_card, parent, false);

        // Create and return our customRecycler View Holder object.
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
                holder.course_section_txt.setText(sectionItem.getSection() + " | " + sectionItem.getDays() + "  " + sectionItem.getTimeSlot() + " | " + sectionItem.getPeriod());
                holder.cardView.setCardBackgroundColor(Color.rgb(125,140,235));

                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClick.onItemClick(position);
                    }
                });
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

    public void setOnClick(RecyclerFacultyDataAdapter.OnItemClicked onClick) {
        this.onClick=onClick;
    }

}

package com.example.birzeitstudyplanner;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import android.widget.ArrayAdapter;

public class ScheduleAdapter extends ArrayAdapter<CourseModel> {
    public ScheduleAdapter(Context context, int resource, List<CourseModel> courses) {
        super(context, resource, courses);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_schedule, parent, false);
        }

        CourseModel course = getItem(position);

        if (course != null) {
            TextView courseNameTextView = convertView.findViewById(R.id.courseNameTextView);
            TextView instructorTextView = convertView.findViewById(R.id.instructorTextView);
            TextView startTimeTextView = convertView.findViewById(R.id.startTimeTextView);
            TextView endTimeTextView = convertView.findViewById(R.id.endTimeTextView);
            TextView daysOfWeekTextView = convertView.findViewById(R.id.daysOfWeekTextView);

            // Set data to views
            courseNameTextView.setText(course.getCourseName());
            instructorTextView.setText(course.getInstructorName());
            startTimeTextView.setText(course.getStartTime());
            endTimeTextView.setText(course.getEndTime());
            daysOfWeekTextView.setText(course.getDaysOfWeek());
        }

        return convertView;
    }
}

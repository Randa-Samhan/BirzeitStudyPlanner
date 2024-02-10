package com.example.birzeitstudyplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ExamAdapter extends ArrayAdapter<ExamModel> {
    public ExamAdapter(Context context, int resource, List<ExamModel> courses) {
        super(context, resource, courses);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.exam_schedule, parent, false);
        }

        ExamModel exam = getItem(position);

        if (exam != null) {
            TextView examNameTextView = convertView.findViewById(R.id.examNameTextView);
            TextView markTextView = convertView.findViewById(R.id.markTextView);
            TextView examDateTextView = convertView.findViewById(R.id.examDateTextView);

            // Set data to views
            examNameTextView.setText(exam.getCourseName());
            markTextView.setText(exam.getMark());
            examDateTextView.setText(exam.getExamDate());
        }

        return convertView;
    }
}

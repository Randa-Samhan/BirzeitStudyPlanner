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

public class InstructorAdapter extends ArrayAdapter<InstroctorModel> {
    public InstructorAdapter(Context context, int resource, List<InstroctorModel> instroctors) {
        super(context, resource, instroctors);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_instructor, parent, false);
        }

        InstroctorModel instoctor = getItem(position);

        if (instoctor != null) {
            TextView NameTextView = convertView.findViewById(R.id.instructorNameTextView);
            TextView hoursTextView = convertView.findViewById(R.id.hoursTextView);

            // Set data to views
            NameTextView.setText(instoctor.getName());
            hoursTextView.setText(instoctor.getHours());
        }

        return convertView;
    }
}

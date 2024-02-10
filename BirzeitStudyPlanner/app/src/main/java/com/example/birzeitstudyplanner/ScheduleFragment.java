package com.example.birzeitstudyplanner;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        communicationService communicationService = new communicationService(requireContext().getApplicationContext());


        communicationService.getCoursesData(new communicationService.CoursesCallback() {
            @Override
            public void onSuccess(List<CourseModel> courses) {
                ScheduleAdapter adapter = new ScheduleAdapter(getContext(), R.layout.item_schedule, courses);
                ListView listView = view.findViewById(R.id.scheduleListView);
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(String errorMessage) {
                // Handle the error, e.g., display a toast or log the error message
                Log.e(TAG, "Error fetching upcoming classes: " + errorMessage);
                // Create the adapter with the filtered classes data
                ScheduleAdapter adapter = new ScheduleAdapter(getContext(), R.layout.item_schedule, new ArrayList<CourseModel>());
                // Set the adapter to the RecyclerView
                ListView listView = view.findViewById(R.id.scheduleListView);
                listView.setAdapter(adapter);
            }
        });
        return view;
    }

}
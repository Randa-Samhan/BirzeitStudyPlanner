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

public class InstructorFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_instructors, container, false);
        communicationService communicationService = new communicationService(requireContext().getApplicationContext());


        communicationService.getInstructorsData(new communicationService.InstructorsCallback() {
            @Override
            public void onSuccess(List<InstroctorModel> instructors) {
                InstructorAdapter adapter = new InstructorAdapter(getContext(), R.layout.item_instructor, instructors);
                ListView listView = view.findViewById(R.id.instructorsListView);
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(String errorMessage) {
                // Handle the error, e.g., display a toast or log the error message
                Log.e(TAG, "Error fetching upcoming classes: " + errorMessage);
                // Create the adapter with the filtered classes data
                InstructorAdapter adapter = new InstructorAdapter(getContext(), R.layout.item_instructor, new ArrayList<InstroctorModel>());
                // Set the adapter to the RecyclerView
                ListView listView = view.findViewById(R.id.instructorsListView);
                listView.setAdapter(adapter);
            }
        });
        return view;
    }

}
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

public class ExamFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exams, container, false);
        communicationService communicationService = new communicationService(requireContext().getApplicationContext());


        communicationService.getExamsData(new communicationService.ExamCallback() {
            @Override
            public void onSuccess(List<ExamModel> examModels) {
                ExamAdapter adapter = new ExamAdapter(getContext(),R.layout.exam_schedule,examModels);
                ListView listView = view.findViewById(R.id.examListView);
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(String errorMessage) {
                // Handle the error, e.g., display a toast or log the error message
                Log.e(TAG, "Error fetching upcoming classes: " + errorMessage);
                ExamAdapter adapter = new ExamAdapter(getContext(),R.layout.exam_schedule,new ArrayList<ExamModel>());
                // Set the adapter to the RecyclerView
                ListView listView = view.findViewById(R.id.examListView);
                listView.setAdapter(adapter);
            }
        });
        return view;
    }

}
package com.example.birzeitstudyplanner;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UpcomingClassesFragment extends Fragment {

    private RecyclerView recyclerView;
    private communicationService communicationService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard_layout, container, false);

        Spinner filterSpinner = view.findViewById(R.id.filterSpinner);

        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.filter_options_array,
                android.R.layout.simple_spinner_item
        );
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        filterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedOption = (String) parentView.getItemAtPosition(position);
                filterClasses(selectedOption);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        filterSpinner.setAdapter(adapterSpinner);

        recyclerView = view.findViewById(R.id.upcomingClassesRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        communicationService = new communicationService(requireContext().getApplicationContext());
        filterClasses("Next 1 Hour");
        return view;
    }

    private void filterClasses(String selectedOption) {
        // Call the API to get upcoming classes data asynchronously
        communicationService.getUpcomingClassesData(new communicationService.UpcomingClassesCallback() {
            @Override
            public void onSuccess(List<UpcomingClassModel> upcomingClasses) {
                List<UpcomingClassModel> filteredClasses = new ArrayList<>();
                for (UpcomingClassModel upcomingClass : upcomingClasses) {
                    int timeRemainingInMinutes = upcomingClass.getTimeRemainingInMinutes();
                    // Filter the upcoming classes based on the selected option
                    switch (selectedOption) {
                        case "Next 1 Hour":
                            if (timeRemainingInMinutes > 0 && timeRemainingInMinutes <= 60) {
                                filteredClasses.add(upcomingClass);
                            }
                            break;
                        case "Next 3 Hours":
                            if (timeRemainingInMinutes > 0 && timeRemainingInMinutes <= 180) {
                                filteredClasses.add(upcomingClass);
                            }
                            break;
                        default:
                            filteredClasses.add(upcomingClass);
                            break;
                    }
                }
                System.out.println("Hello, " + filteredClasses.size());
                // Create the adapter with the filtered classes data
                UpcomingClassesAdapter adapter = new UpcomingClassesAdapter(filteredClasses);

                // Set the adapter to the RecyclerView
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(String errorMessage) {
                // Handle the error, e.g., display a toast or log the error message
                Log.e(TAG, "Error fetching upcoming classes: " + errorMessage);
                // Create the adapter with the filtered classes data
                UpcomingClassesAdapter adapter = new UpcomingClassesAdapter(new ArrayList<UpcomingClassModel>());

                // Set the adapter to the RecyclerView
                recyclerView.setAdapter(adapter);
            }
        });
    }


}
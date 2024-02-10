package com.example.birzeitstudyplanner;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        communicationService communicationService = new communicationService(requireContext().getApplicationContext());

        communicationService.GetStudent (new communicationService.StudentCallback() {
            @Override
            public void onSuccess(StudentModel tStudent) {

                // Fetch student information
                String firstName = tStudent.getFirstName();
                String lastName = tStudent.getLastName();
                String birthdate = tStudent.getBirthdate();
                String gpa = tStudent.getGpa();
                String registrationDate = tStudent.getRegistrationDate();

                // Update TextViews
                TextView firstNameTextView = view.findViewById(R.id.firstNameTextView);
                firstNameTextView.setText(firstName);

                TextView lastNameTextView = view.findViewById(R.id.lastNameTextView);
                lastNameTextView.setText(lastName);

                TextView birthdateTextView = view.findViewById(R.id.birthdateTextView);
                birthdateTextView.setText("Birthdate: " + birthdate);

                TextView gpaTextView = view.findViewById(R.id.gpaTextView);
                gpaTextView.setText("GPA: " + gpa);

                TextView registrationDateTextView = view.findViewById(R.id.registrationDateTextView);
                registrationDateTextView.setText("Registration Date: " + registrationDate);
            }

            @Override
            public void onError(String errorMessage) {

            }
        });


        return view;
    }
}

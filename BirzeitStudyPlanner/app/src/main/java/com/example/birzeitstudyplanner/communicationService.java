package com.example.birzeitstudyplanner;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class communicationService {
    private static final String BASE_URL = "http://10.0.2.2:5000/api/";

    private  Context context;
    public  communicationService(Context pContext){
        this.context = pContext;
    }
   // private BackendAPI backendAPI = BackendAPI.getInstance(this.context);

    public void getUpcomingClassesData(final UpcomingClassesCallback callback) {
        int studentId = 1;
        String url = BASE_URL + "student/" + studentId + "/upcoming_classes";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<UpcomingClassModel> upcomingClasses = new ArrayList<>();
                        try {
                            // Parse the JSON response
                            for (int i = 0; i < response.length(); i++) {
                                JSONArray jsonObject = response.getJSONArray(i);
                                String className = jsonObject.get(0).toString();
                                String classLocation = jsonObject.get(1).toString();
                                String timeRemaining = jsonObject.get(2).toString();
                                int timeRemainingInMinutes = Integer.parseInt(jsonObject.get(3).toString());
                                // Create an instance of UpcomingClassModel and add it to the list
                                UpcomingClassModel upcomingClass = new UpcomingClassModel(className, classLocation, timeRemaining);
                                upcomingClass.setTimeRemainingInMinutes((timeRemainingInMinutes));
                                upcomingClasses.add(upcomingClass);
                            }
                            // Pass the list of upcoming classes to the callback
                            callback.onSuccess(upcomingClasses);
                        } catch (JSONException e) {
                            Log.e("BackendAPI", "Error parsing JSON response: " + e.getMessage());
                            // Notify the callback of the error
                            callback.onError("Error parsing JSON response: " + e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("BackendAPI", "Error fetching upcoming classes: " + error.getMessage());
                        // Notify the callback of the error
                        callback.onError("Error fetching upcoming classes: " + error.getMessage());
                    }
                });

        // Add the request to the Volley request queue
        Volley.newRequestQueue(context).add(jsonArrayRequest);
    }

    // Define an interface for the callback
    interface UpcomingClassesCallback {
        void onSuccess(List<UpcomingClassModel> upcomingClasses);
        void onError(String errorMessage);
    }


    interface CoursesCallback {
        void onSuccess(List<CourseModel> upcomingClasses);
        void onError(String errorMessage);
    }

    interface InstructorsCallback {
        void onSuccess(List<InstroctorModel> upcomingClasses);
        void onError(String errorMessage);
    }

    public void getCoursesData(final CoursesCallback callback) {
        int studentId = 1; // Assuming the student ID is hardcoded for now
        String url = BASE_URL + "student_registered_courses/1";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<CourseModel> coursesList = new ArrayList<>();
                        try {

                            for (int i = 0; i < response.length(); i++) {
                                JSONArray jsonObject = response.getJSONArray(i);
                                String courseName = jsonObject.get(1).toString();
                                String InstroctorName = jsonObject.get(2).toString();
                                String startTime=jsonObject.get(4).toString();
                                String endTime=jsonObject.get(5).toString();
                                String daysOfWeeks=jsonObject.get(3).toString();
                                // Create an instance of CourseModel and add it to the list
                                CourseModel course = new CourseModel(courseName,InstroctorName,startTime,endTime,daysOfWeeks);
                                coursesList.add(course);
                            }
                            // Pass the list of courses to the callback
                            System.out.println("Courses->"+coursesList.size());
                            callback.onSuccess(coursesList);
                        } catch (JSONException e) {
                            Log.e("BackendAPI", "Error parsing JSON response: " + e.getMessage());
                            // Notify the callback of the error
                            callback.onError("Error parsing JSON response: " + e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("BackendAPI", "Error fetching courses data: " + error.getMessage());
                        // Notify the callback of the error
                        callback.onError("Error fetching courses data: " + error.getMessage());
                    }
                });

        // Add the request to the Volley request queue
        Volley.newRequestQueue(context).add(jsonArrayRequest);
    }


    interface StudentCallback {
        void onSuccess(StudentModel student);
        void onError(String errorMessage);
    }

    public void GetStudent(final StudentCallback callback) {
        int studentId = 1; // Assuming the student ID is hardcoded for now
        String url = BASE_URL + "student/1";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        StudentModel tStudent = new StudentModel("","","","","");

                        try {

                            for (int i = 0; i < response.length(); i++) {
                                JSONArray jsonObject = response.getJSONArray(i);
                                String firstName = jsonObject.get(0).toString();
                                String lastName = jsonObject.get(1).toString();
                                String birthData =jsonObject.get(3).toString();
                                String gpa=jsonObject.get(2).toString();
                                String registrationDate=jsonObject.get(4).toString();

                                tStudent = new StudentModel(firstName,lastName,birthData,gpa,registrationDate);

                            }
                            callback.onSuccess(tStudent);
                        } catch (JSONException e) {
                            Log.e("BackendAPI", "Error parsing JSON response: " + e.getMessage());
                            // Notify the callback of the error
                            callback.onError("Error parsing JSON response: " + e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("BackendAPI", "Error fetching courses data: " + error.getMessage());
                        // Notify the callback of the error
                        callback.onError("Error fetching courses data: " + error.getMessage());
                    }
                });

        // Add the request to the Volley request queue
        Volley.newRequestQueue(context).add(jsonArrayRequest);
    }

    interface ExamCallback {
        void onSuccess(List<ExamModel> exams);
        void onError(String errorMessage);
    }

    public void getExamsData(final ExamCallback callback) {
        int studentId = 1; // Assuming the student ID is hardcoded for now
        String url = BASE_URL + "student_exams/1";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<ExamModel> exams = new ArrayList<>();
                        try {

                            for (int i = 0; i < response.length(); i++) {
                                JSONArray jsonObject = response.getJSONArray(i);
                                String courseName = jsonObject.get(1).toString();
                                String examDate = jsonObject.get(2).toString();
                                String result = jsonObject.get(3).toString();
                                String mark = "";
                                if(result.equals("-1")){
                                    mark="";
                                }else{
                                    mark=jsonObject.get(6).toString();
                                }
                                int status = Integer.parseInt(jsonObject.get(7).toString());
                                // Create an instance of CourseModel and add it to the list
                                ExamModel exam = new ExamModel(courseName,examDate,mark,status);
                                exams.add(exam);
                            }
                            callback.onSuccess(exams);
                        } catch (JSONException e) {
                            Log.e("BackendAPI", "Error parsing JSON response: " + e.getMessage());
                            // Notify the callback of the error
                            callback.onError("Error parsing JSON response: " + e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("BackendAPI", "Error fetching courses data: " + error.getMessage());
                        // Notify the callback of the error
                        callback.onError("Error fetching courses data: " + error.getMessage());
                    }
                });

        // Add the request to the Volley request queue
        Volley.newRequestQueue(context).add(jsonArrayRequest);
    }


    public void getInstructorsData(final InstructorsCallback callback) {
        int studentId = 1; // Assuming the student ID is hardcoded for now
        String url = BASE_URL + "instructors";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<InstroctorModel> instructors = new ArrayList<>();
                        try {

                            for (int i = 0; i < response.length(); i++) {
                                JSONArray jsonObject = response.getJSONArray(i);
                                String name = jsonObject.get(1).toString();
                                String hours = jsonObject.get(2).toString();
                                InstroctorModel instructor = new InstroctorModel(name,hours);
                                instructors.add(instructor);
                            }
                            callback.onSuccess(instructors);
                        } catch (JSONException e) {
                            Log.e("BackendAPI", "Error parsing JSON response: " + e.getMessage());
                            // Notify the callback of the error
                            callback.onError("Error parsing JSON response: " + e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("BackendAPI", "Error fetching courses data: " + error.getMessage());
                        // Notify the callback of the error
                        callback.onError("Error fetching courses data: " + error.getMessage());
                    }
                });

        // Add the request to the Volley request queue
        Volley.newRequestQueue(context).add(jsonArrayRequest);
    }


}

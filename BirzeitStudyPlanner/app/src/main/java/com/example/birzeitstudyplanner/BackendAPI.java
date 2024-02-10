package com.example.birzeitstudyplanner;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BackendAPI {
    private static BackendAPI instance;
    private RequestQueue requestQueue;
    private static Context context;

    private BackendAPI(Context ctx) {
        context = ctx;
        requestQueue = getRequestQueue();
    }

    public static synchronized BackendAPI getInstance(Context context) {
        if (instance == null) {
            instance = new BackendAPI(context);
        }
        return instance;
    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public void login(String uidEmail, String password, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        String url = "http://localhost:5000/api/login";
        JSONObject requestBody = new JSONObject();
        try {
            requestBody.put("uid_email", uidEmail);
            requestBody.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, requestBody, listener, errorListener);
        addToRequestQueue(jsonObjectRequest);
    }

    public void getUpcomingClasses(int studentId, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        String url = "http://localhost:5000/api/student/" + studentId + "/upcoming_classes";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, listener, errorListener);
        addToRequestQueue(jsonArrayRequest);
    }

    public void getUpcomingClassesNextHour(int studentId, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        String url = "http://localhost:5000/api/student/" + studentId + "/upcoming_classes/next_hour";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, listener, errorListener);
        addToRequestQueue(jsonArrayRequest);
    }

    public void getUpcomingClassesNextThreeHours(int studentId, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        String url = "http://localhost:5000/api/student/" + studentId + "/upcoming_classes/next_three_hours";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, listener, errorListener);
        addToRequestQueue(jsonArrayRequest);
    }
}


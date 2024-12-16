package com.luv.cricket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private boolean current = false;
    private String api = "15a14d5a-207a-4690-8522-abc0063ac92a";

    private String allMatchesURL = "https://api.cricapi.com/v1/cricScore?apikey=" + api;
    private String currentMatchesURL = "https://api.cricapi.com/v1/currentMatches?apikey=" + api + "&offset=0";

    private RecyclerView.Adapter mAdapter;
    private List<Model1> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        modelList = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadAllMatchesData();
        current = false;
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.all:
                if(current){
                    loadAllMatchesData();
                    current = false;
                } else {
                    Toast.makeText(this, "You are already seeing all the matches", Toast.LENGTH_SHORT).show();
                }
                return true;

            case R.id.current:
                if (!current){
                    loadCurrentMatchesData();
                    current = true;
                } else {
                    Toast.makeText(this, "You are already seeing the current matches", Toast.LENGTH_SHORT).show();
                }
                return true;
            default:
                return true;
        }
    }
*/
/*    private void loadCurrentMatchesData() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();
        Log.i("Success", "Current Matches Loaded Successfully");
        modelList.clear();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, currentMatchesURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                pd.dismiss();

                try {

                    JSONArray jsonArray = new JSONObject(response).getJSONArray("data");


                    for (int i =0; i<jsonArray.length(); i++)
                    {
                        try {

                            String uniqueId = jsonArray.getJSONObject(i).getString("id");
                            String team1 = "", team2 = "", team1Logo = "", team2Logo = "";
                            String matchType = "";
                            JSONArray teamarray = jsonArray.getJSONObject(i).getJSONArray("teams");
                            for (int j=0; j<=teamarray.length(); j++){
                                team1 = teamarray.getString(0);
                                team2 = teamarray.getString(1);
                            }
                            try {
                                JSONArray team_array = jsonArray.getJSONObject(i).getJSONArray("teamInfo");
                                for (int j=0; j<=team_array.length(); j++){
                                    team1Logo = team_array.getJSONObject(0).getString("img");
                                    team2Logo = team_array.getJSONObject(1).getString("img");
                                    team1 = team_array.getJSONObject(0).getString("name");
                                    team2 = team_array.getJSONObject(1).getString("name");
                                }
                            } catch (Exception e){
                                Log.e("Error", e.getMessage());
                            }
                            try {
                                JSONArray score_array = jsonArray.getJSONObject(i).getJSONArray("score");
                                team1 += " " + score_array.getJSONObject(0).getString("r") + "/" + score_array.getJSONObject(0).getString("w") + " (" + score_array.getJSONObject(0).getString("o") + ")";
                                team2 += " " + score_array.getJSONObject(1).getString("r") + "/" + score_array.getJSONObject(1).getString("w") + " (" + score_array.getJSONObject(1).getString("o") + ")";
                            } catch (Exception e){
                                Log.e("Error", e.getMessage());
                            }
                            try {
                                matchType = jsonArray.getJSONObject(i).getString("matchType").toUpperCase();
                            } catch (Exception e) {
                                Log.e("Error", e.getMessage());
                            }
                            String matchStatus = jsonArray.getJSONObject(i).getString("status");
                            String venue = jsonArray.getJSONObject(i).getString("venue");
                            String dateTimeGMT = jsonArray.getJSONObject(i).getString("dateTimeGMT");
                            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                            format1.setTimeZone(TimeZone.getTimeZone(dateTimeGMT));
                            Date date = format1.parse(dateTimeGMT);

                            SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                            format2.setTimeZone(TimeZone.getTimeZone("GMT"));
                            String dateTime = format2.format(date);


                            Model1 model1 = new Model1(uniqueId, team1, team2, matchStatus, matchType, venue, dateTime, team1Logo, team2Logo);
                            modelList.add(model1);


                        }catch (Exception e){
                            Log.e("Error", e.getMessage());
                        }
                    }

                    mAdapter = new MyAdapter(modelList, getApplicationContext());
                    mRecyclerView.setAdapter(mAdapter);

                }catch (Exception e){
                    Log.e("Error", e.getMessage());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Log.e("Error", e.getMessage());
            }
        });

        MySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
*/
    private void loadAllMatchesData() {

        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();
        modelList.clear();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, allMatchesURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                pd.dismiss();

                try {

                    JSONArray jsonArray = new JSONObject(response).getJSONArray("data");


                    for (int i =0; i<jsonArray.length(); i++)
                    {
                        try {

                            String uniqueId = jsonArray.getJSONObject(i).getString("id");
                            String team1Logo = "", team2Logo = "";
                            String team1 = jsonArray.getJSONObject(i).getString("t1");
                            String team2 = jsonArray.getJSONObject(i).getString("t2");
                            String matchType = "";
                            try {
                                team1Logo = jsonArray.getJSONObject(i).getString("t1img");
                                team2Logo = jsonArray.getJSONObject(i).getString("t2img");
                            } catch (Exception e){
                                Log.e("Error", e.getMessage());
                            }
                            try {
                                team1 += " " + jsonArray.getJSONObject(i).getString("t1s");
                                team2 += " " + jsonArray.getJSONObject(i).getString("t2s");
                            } catch (Exception e){
                                Log.e("Error", e.getMessage());
                            }
                            try {
                                matchType = jsonArray.getJSONObject(i).getString("matchType").toUpperCase();
                            } catch (Exception e) {
                                Log.e("Error", e.getMessage());
                            }
                            String matchStatus = jsonArray.getJSONObject(i).getString("status");
                            String venue = jsonArray.getJSONObject(i).getString("ms");
                            String dateTimeGMT = jsonArray.getJSONObject(i).getString("dateTimeGMT");
                            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                            format1.setTimeZone(TimeZone.getTimeZone(dateTimeGMT));
                            Date date = format1.parse(dateTimeGMT);

                            SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                            format2.setTimeZone(TimeZone.getTimeZone("GMT"));
                            String dateTime = format2.format(date);


                            Model1 model1 = new Model1(uniqueId, team1, team2, matchStatus, matchType, venue, dateTime, team1Logo, team2Logo);
                            modelList.add(model1);


                        }catch (Exception e){
                            Log.e("Error", e.getMessage());
                        }
                    }

                    mAdapter = new MyAdapter(modelList, getApplicationContext());
                    mRecyclerView.setAdapter(mAdapter);

                }catch (Exception e){
                    Log.e("Error", e.getMessage());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Log.e("Error", e.getMessage());
            }
        });

        MySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}

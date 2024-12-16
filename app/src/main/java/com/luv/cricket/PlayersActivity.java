package com.luv.cricket;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PlayersActivity extends AppCompatActivity {

    TextView team1NameTv, team2NameTv;
    private RecyclerView team1PlayersTv, team2PlayersTv;
    private ArrayList<PlayerModel> team1PlayerModelList = new ArrayList<>();
    private ArrayList<PlayerModel1> team2PlayerModelList = new ArrayList<>();
    private RecyclerView.Adapter team1Adapter, team2Adapter;
    private String api = "15a14d5a-207a-4690-8522-abc0063ac92a";
    private String url = "https://api.cricapi.com/v1/match_squad?apikey=" + api + "&offset=0&id=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Players");

        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String uniqueId = intent.getStringExtra("match_id");
        url = url + uniqueId;

        team1NameTv = findViewById(R.id.team1NameTV);
        team2NameTv = findViewById(R.id.team2NameTV);
        team1PlayersTv = findViewById(R.id.team1PlayersTV);
        team2PlayersTv = findViewById(R.id.team2PlayersTV);

        team1PlayersTv.setHasFixedSize(true);
        team1PlayersTv.setLayoutManager(new LinearLayoutManager(this));
        team1PlayerModelList = new ArrayList<>();
//        team1PlayersTv.setAdapter(team1Adapter);
        loadTeam1Data();

        team2PlayersTv.setHasFixedSize(true);
        team2PlayersTv.setLayoutManager(new LinearLayoutManager(this));
        team2PlayerModelList = new ArrayList<>();
//        team2PlayersTv.setAdapter(team2Adapter);
        for(int i=1; i<=2; i++){
            System.out.println(i);
        }
        loadTeam2Data();

    }

    private void loadTeam1Data() {
        
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                pd.dismiss();

                try {

                    JSONArray squadArray = new JSONObject(response).getJSONArray("data");

                    JSONObject json0 = squadArray.getJSONObject(0);

                    String team1Name =  json0.getString("teamName");

                    JSONArray team1Array = json0.getJSONArray("players");

                    team1NameTv.setText(team1Name);

                    try {
                        Log.i("Info", "Team 1 reached");
                        for (int i = 0; i < team1Array.length(); i++) {
                            String playerId = team1Array.getJSONObject(i).getString("id");
                            String playerName = team1Array.getJSONObject(i).getString("name");
                            String playerImage = team1Array.getJSONObject(i).getString("playerImg");
//                        if(!team1Array.getJSONObject(i).getString("role").equals("WK-Batsman")) {
//                            playerDetails = "Role: " + team1Array.getJSONObject(i).getString("role") + "\n"
//                                        + "Batting Style: " + team1Array.getJSONObject(i).getString("battingStyle") + "\n"
//                                        + "Bowling Style: " + team1Array.getJSONObject(i).getString("bowlingStyle") + "\n"
//                                        + "Nationality: " + team1Array.getJSONObject(i).getString("country");
//                            } else {
                            String playerDetails = team1Array.getJSONObject(i).getString("role") + "\n"
                                    + team1Array.getJSONObject(i).getString("country");
//                            }

                            PlayerModel playerModel = new PlayerModel(playerId, playerName, playerImage, playerDetails);
                            team1PlayerModelList.add(playerModel);

                        }
                        team1Adapter = new PlayerAdapter(team1PlayerModelList, getApplicationContext());
                        team1PlayersTv.setAdapter(team1Adapter);
//                        team1Adapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                    }

                } catch (Exception e){
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

    private void loadTeam2Data() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.dismiss();
                try {
                    JSONArray squadArray = new JSONObject(response).getJSONArray("data");

                    JSONObject json1 = squadArray.getJSONObject(1);
                    String team2Name =  json1.getString("teamName");
                    JSONArray team2Array = json1.getJSONArray("players");
                    team2NameTv.setText(team2Name);

                    try {
                        Log.i("Info", "Team 2 reached");
                        for (int i = 0; i < team2Array.length(); i++) {

                            String playerId = team2Array.getJSONObject(i).getString("id");
                            String playerName = team2Array.getJSONObject(i).getString("name");
                            String playerImage = team2Array.getJSONObject(i).getString("playerImg");
//                            if(!team2Array.getJSONObject(i).getString("role").equals("WK-Batsman")) {
//                                playerDetails = "Role: " + team2Array.getJSONObject(i).getString("role") + "\n"
//                                        + "Batting Style: " + team2Array.getJSONObject(i).getString("battingStyle") + "\n"
//                                        + "Bowling Style: " + team2Array.getJSONObject(i).getString("bowlingStyle") + "\n"
//                                        + "Nationality: " + team2Array.getJSONObject(i).getString("country");
//                            } else {
                            String playerDetails = team2Array.getJSONObject(i).getString("role") + "\n"
                                    + team2Array.getJSONObject(i).getString("country");
//                            }

                            PlayerModel1 playerModel = new PlayerModel1(playerId, playerName, playerImage, playerDetails);
                            team2PlayerModelList.add(playerModel);
                        }

                        team2Adapter = new PlayerAdapter1(team2PlayerModelList, getApplicationContext());
                        team2PlayersTv.setAdapter(team2Adapter);
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                    }
                } catch (Exception e){
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

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return super.onSupportNavigateUp();
    }
}

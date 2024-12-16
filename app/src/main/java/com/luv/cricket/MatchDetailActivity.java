package com.luv.cricket;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MatchDetailActivity extends AppCompatActivity {

    TextView mTeam1TV, mTeam2TV, mMatchStatusTV, mScoreTV, mDescriptionTV, mDateTV, mVenueTV, mTossTV;
    private String api = "15a14d5a-207a-4690-8522-abc0063ac92a";

    private String url = "https://api.cricapi.com/v1/match_info?apikey=" + api + "&offset=0&id=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Match Detail");

        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String id = intent.getStringExtra("match_id");
        String date = intent.getStringExtra("date");
        url = url+id;

        mTeam1TV = findViewById(R.id.team1TV);
        mTeam2TV = findViewById(R.id.team2TV);
        mMatchStatusTV = findViewById(R.id.matchStatusTV);
        mScoreTV = findViewById(R.id.scoreTV);
        mDescriptionTV = findViewById(R.id.descriptionTV);
        mDateTV = findViewById(R.id.dateTV);
        mVenueTV = findViewById(R.id.venueTV);
        mTossTV = findViewById(R.id.tossTV);

        mDateTV.setText(date);

        loadData();

    }

    private void loadData() {

        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        pd.dismiss();

                        try {

//                            JSONArray jsonArray = new JSONObject(response).getJSONArray("data");
                            JSONObject jsonObject = new JSONObject(response).getJSONObject("data");

                            JSONArray team_array = jsonObject.getJSONArray("teams");
                            String team1 = "", team2 = "";
                            for (int j=0; j<=team_array.length(); j++){
                                team1 = team_array.get(0).toString();
                                team2 = team_array.get(1).toString();
                            }
                            String matchStatus = jsonObject.getString("status");
                            String venue = jsonObject.getString("venue");

                            mTeam1TV.setText(team1);
                            mTeam2TV.setText(team2);
                            mMatchStatusTV.setText(matchStatus);
                            mVenueTV.setText(venue);

                            try {
                                JSONArray score_array = jsonObject.getJSONArray("score");
                                String score="";
                                for (int j=0; j<=score_array.length()-1; j++) {
                                    score += score_array.getJSONObject(j).getString("inning") + "\t"
                                            + score_array.getJSONObject(j).getString("r") + "/"
                                            + score_array.getJSONObject(j).getString("w") + "\n";
                                }
                                score = score.substring(0, score.length()-1);
                                String description = jsonObject.getString("name");
                                String toss = jsonObject.getString("tossWinner") + " chose to " + jsonObject.getString("tossChoice");

                                mScoreTV.setText(score);
                                mDescriptionTV.setText(description);
                                mTossTV.setText(toss);

                            }catch (Exception e){
                                Log.e("Error", e.getMessage());
                            }

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

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return super.onSupportNavigateUp();
    }
}

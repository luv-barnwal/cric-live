package com.luv.cricket;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Locale;

public class MatchSummaryActivity extends AppCompatActivity {

    private String api = "15a14d5a-207a-4690-8522-abc0063ac92a";
    private String url = "https://api.cricapi.com/v1/match_scorecard?apikey=" + api +"&id=";

    TextView bowlT1DetailTv, batT1TitleTv, batT1DetailTv,
            bowlT2DetailTv, batT2TitleTv, batT2DetailTv,
            bowlT3DetailTv, batT3TitleTv, batT3DetailTv,
            bowlT4DetailTv, batT4TitleTv, batT4DetailTv,
            otherResultsTV;
    String matchType = "";
    CardView innings_1_card, innings_2_card, innings_3_card, innings_4_card, results_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_summary);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Match Summary");

        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        String uniqueId = intent.getStringExtra("match_id");
        url = url + uniqueId;
        matchType = intent.getStringExtra("match_type");

        bowlT1DetailTv = findViewById(R.id.bowlT1DetailTv);
        batT1TitleTv = findViewById(R.id.batT1TitleTv);
        batT1DetailTv = findViewById(R.id.batT1DetailTv);

        bowlT2DetailTv = findViewById(R.id.bowlT2DetailTv);
        batT2TitleTv = findViewById(R.id.batT2TitleTv);
        batT2DetailTv = findViewById(R.id.batT2DetailTv);

        bowlT3DetailTv = findViewById(R.id.bowlT3DetailTv);
        batT3TitleTv = findViewById(R.id.batT3TitleTv);
        batT3DetailTv = findViewById(R.id.batT3DetailTv);

        bowlT4DetailTv = findViewById(R.id.bowlT4DetailTv);
        batT4TitleTv = findViewById(R.id.batT4TitleTv);
        batT4DetailTv = findViewById(R.id.batT4DetailTv);

        otherResultsTV = findViewById(R.id.otherResultsTV);

        innings_1_card = findViewById(R.id.innings_1_card);
        innings_2_card = findViewById(R.id.innings_2_card);
        innings_3_card = findViewById(R.id.innings_3_card);
        innings_4_card = findViewById(R.id.innings_4_card);
        results_card = findViewById(R.id.results_card);

        if(!matchType.equalsIgnoreCase("TEST")){
            innings_3_card.setVisibility(View.GONE);
            innings_4_card.setVisibility(View.GONE);
        }

        loadData();

    }

    private void loadData() {

        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET
                , url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                pd.dismiss();

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject dataJObject = jsonObject.getJSONObject("data");
                    JSONArray scoreArray = dataJObject.getJSONArray("scorecard");
                    JSONArray score = dataJObject.getJSONArray("score");
                    try {
                        batT1TitleTv.setText(score.getJSONObject(0).getString("inning") + ": " + scoreArray.getJSONObject(0).getString("r") + "/" + scoreArray.getJSONObject(0).getString("w") + "\t(" + scoreArray.getJSONObject(0).getString("o") + ")");
                        batT2TitleTv.setText(score.getJSONObject(1).getString("inning") + ": " + scoreArray.getJSONObject(1).getString("r") + "/" + scoreArray.getJSONObject(1).getString("w") + "\t(" + scoreArray.getJSONObject(1).getString("o") + ")");
                    } catch (Exception e){
                        Log.i("Dumb", "This is dumb");
                        Log.e("Error", e.getMessage());
                    }
//                    if(batT1TitleTv.getText().equals("Innings 1")){
//                        innings_1_card.setVisibility(View.GONE);
//                    }
//                    if (batT2TitleTv.getText().equals("Innings 2")){
//                        innings_2_card.setVisibility(View.GONE);
//                    }
                    try {
                        batT3TitleTv.setText(score.getJSONObject(2).getString("inning") + ": " + scoreArray.getJSONObject(2).getString("r") + "/" + scoreArray.getJSONObject(2).getString("w") + "\t(" + scoreArray.getJSONObject(2).getString("o") + ")");
                        batT4TitleTv.setText(score.getJSONObject(3).getString("inning") + ": " + scoreArray.getJSONObject(3).getString("r") + "/" + scoreArray.getJSONObject(3).getString("w") + "\t(" + scoreArray.getJSONObject(3).getString("o") + ")");
                    } catch (Exception e){
                        Log.e("Error", e.getMessage());
                    }
//                    if (batT3TitleTv.getText().equals("Innings 3")){
//                        innings_3_card.setVisibility(View.GONE);
//                    }
//                    if (batT4TitleTv.getText().equals("Innings 4")){
//                        innings_4_card.setVisibility(View.GONE);
//                    }
                    for (int i = 0; i<scoreArray.length(); i++){
                        JSONArray battingArray = scoreArray.getJSONObject(i).getJSONArray("batting");
                        JSONArray bowlingArray = scoreArray.getJSONObject(i).getJSONArray("bowling");
                        for (int j = 0; j<battingArray.length(); j++){
                            String batsman = battingArray.getJSONObject(j).getJSONObject("batsman").getString("name");
                            String runs = battingArray.getJSONObject(j).getString("r");
                            String balls = battingArray.getJSONObject(j).getString("b");
                            String fours = battingArray.getJSONObject(j).getString("4s");
                            String sixes = battingArray.getJSONObject(j).getString("6s");
                            String strikeRate = battingArray.getJSONObject(j).getString("sr");
                            String dismissal = battingArray.getJSONObject(j).getString("dismissal-text");
                            String batsmanInfo = "Batsman : "+ batsman
                                    + "\nRuns : "+ runs
                                    + "\nBalls : "+ balls
                                    + "\n4s : "+ fours
                                    + "\n6s : "+ sixes
                                    + "\nSR : "+ strikeRate
                                    + "\nDismissal : "+ dismissal
                                    + "\n\n";
                            if(i==0){
                                batT1DetailTv.append(batsmanInfo);
                            } else if (i==1){
                                batT2DetailTv.append(batsmanInfo);
                            } else if (i==2){
                                batT3DetailTv.append(batsmanInfo);
                            } else if (i==3){
                                batT4DetailTv.append(batsmanInfo);
                            }
                        }
                        for (int j = 0; j<bowlingArray.length(); j++){
                            String bowlerName = bowlingArray.getJSONObject(j).getJSONObject("bowler").getString("name");
                            String overs = bowlingArray.getJSONObject(j).getString("o");
                            String maidens = bowlingArray.getJSONObject(j).getString("m");
                            String runs = bowlingArray.getJSONObject(j).getString("r");
                            String wickets = bowlingArray.getJSONObject(j).getString("w");
                            String noballs = bowlingArray.getJSONObject(j).getString("nb");
                            String wides = bowlingArray.getJSONObject(j).getString("wd");
                            String economy = bowlingArray.getJSONObject(j).getString("eco");
                            String bowlerInfo = "Bowler Name : "+ bowlerName
                                    +"\nOvers : "+ overs
                                    +"\nWickets : "+ wickets
                                    +"\nRuns : "+ runs
                                    +"\nNo Balls : "+ noballs
                                    +"\nWides : "+ wides
                                    +"\nEconomy : "+ economy
                                    +"\nMaidens : "+ maidens + "\n\n";
                            if(i==0){
                                bowlT1DetailTv.append(bowlerInfo);
                            } else if (i==1){
                                bowlT2DetailTv.append(bowlerInfo);
                            } else if (i==2){
                                bowlT3DetailTv.append(bowlerInfo);
                            } else if (i==3){
                                bowlT4DetailTv.append(bowlerInfo);
                            }
                        }
                        JSONObject extrasObject = scoreArray.getJSONObject(i).getJSONObject("extras");
                        String extras = "Extras: " + extrasObject.getString("r") + " (";
                        Log.i("Runs", extrasObject.getString("r"));
                        if (!extrasObject.getString("b").equals(Integer.toString(0))) {
                            extras += " B:" + extrasObject.getString("b");
                        }
                        if (!extrasObject.getString("lb").equals(Integer.toString(0))) {
                            extras += " LB:" + extrasObject.getString("lb");
                        }
                        if (!extrasObject.getString("w").equals(Integer.toString(0))) {
                            extras += " W:" + extrasObject.getString("w");
                        }
                        if (!extrasObject.getString("nb").equals(Integer.toString(0))) {
                            extras += " NB:" + extrasObject.getString("nb");
                        }
                        if (!extrasObject.getString("p").equals(Integer.toString(0))) {
                            extras += " P:" + extrasObject.getString("p");
                        }
                        extras += " )\n\n";
                        if (i == 0) {
                            batT1DetailTv.append(extras);
                        } else if (i == 1) {
                            batT2DetailTv.append(extras);
                        } else if (i == 2) {
                            batT3DetailTv.append(extras);
                        } else if (i == 3) {
                            batT4DetailTv.append(extras);
                        }
                    }

                    String manOfTheMatch = "", tossWinner = "", winnerTeam = "", tossChoice = "";
//                    try {
//
//                        manOfTheMatch = dataJObject.getJSONObject("man-of-the-match").getString("name");
//
//                    }catch (Exception e){
//                        Log.e("Error", e.getMessage());
//                    }

                    try {

                        tossWinner = dataJObject.getString("tossWinner");

                    }catch (Exception e){
                        Log.e("Error", e.getMessage());
                    }

                    try {

                        tossChoice = dataJObject.getString("tossChoice");

                    }catch (Exception e){
                        Log.e("Error", e.getMessage());
                    }

                    try {

                        winnerTeam = dataJObject.getString("matchWinner");

                    }catch (Exception e){
                        Log.e("Error", e.getMessage());
                    }

                    otherResultsTV.setText(tossWinner + " won the toss and chose to " + tossChoice
                    + "\n"+ winnerTeam);
//                    + "\nMan of the Match : "+ manOfTheMatch);

                }catch (Exception e){
                    Log.e("Error", e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MatchSummaryActivity.this,"Error:"+error.toString(),Toast.LENGTH_SHORT).show();
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

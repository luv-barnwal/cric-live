package com.luv.cricket;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class PlayerInfoActivity extends AppCompatActivity {

    TextView playerNameTV, playerRoleTV, playerNationalityTV, playerBattingTV, playerBowlingTV;
    ImageView playerImageTV;
    private String api = "15a14d5a-207a-4690-8522-abc0063ac92a";

    private String url = "https://api.cricapi.com/v1/players_info?apikey=" + api + "&offset=0&id=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Player Detail");

        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String playerID = intent.getStringExtra("player_id");
        url = url + playerID;

        playerNameTV = findViewById(R.id.player_name);
        playerRoleTV = findViewById(R.id.player_role);
        playerNationalityTV = findViewById(R.id.player_country);
        playerImageTV = findViewById(R.id.player_image);
        playerBattingTV = findViewById(R.id.player_batting);
        playerBowlingTV = findViewById(R.id.player_bowling);

        loadData();
    }

    private void loadData() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.dismiss();

                try {

                    JSONObject jsonObject = new JSONObject(response).getJSONObject("data");
                    String name = jsonObject.getString("name");
                    String role = jsonObject.getString("role");
                    String nation = jsonObject.getString("country");
                    String birthPlace = jsonObject.getString("placeOfBirth");
                    String image = jsonObject.getString("playerImg");
                    String batting = jsonObject.getString("battingStyle");
                    String bowling = "-";

                    try {
                        bowling = jsonObject.getString("bowlingStyle");
                    } catch (Exception e){
                        Log.e("Error", e.getMessage());
                    }

                    playerNameTV.setText(name);
                    playerRoleTV.setText(role);
                    playerNationalityTV.setText(nation);
                    playerBattingTV.setText(batting);
                    playerBowlingTV.setText(bowling);

                    if(!image.equals("https://cdorgapi.b-cdn.net/img/icon512.png")){
                        Glide.with(PlayerInfoActivity.this).load(image).into(playerImageTV);
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
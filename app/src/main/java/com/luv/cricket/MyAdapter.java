package com.luv.cricket;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Model1> modelList;
    private Context context;

    public MyAdapter(List<Model1> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Model1 model1 = modelList.get(position);
        holder.team1TV.setText(model1.getTeam1());
        holder.team2TV.setText(model1.getTeam2());
        holder.matchTypeTV.setText(model1.getMatchType());
        holder.matchStatusTV.setText(model1.getMatchStatus());
        holder.venueTV.setText(model1.getVenue());
        holder.dateTV.setText(model1.getDate());
        if(!model1.getTeam1Image().isEmpty()) {
            Glide.with(context).load(model1.getTeam1Image()).into(holder.team1Logo);
        }
        if (!model1.getTeam2Image().isEmpty()) {
            Glide.with(context).load(model1.getTeam2Image()).into(holder.team2Logo);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String matchId = model1.getId();
                final String date = model1.getDate();
                final String matchType = model1.getMatchType();

                String[] options = {"Match Detail", "Players List", "Match Summary"};
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());
                builder.setTitle("Choose Option");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(context, MatchDetailActivity.class);
                            intent.putExtra("match_id",matchId);
                            intent.putExtra("date",date);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(context, PlayersActivity.class);
                            intent.putExtra("match_id",matchId);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);

                        }
                        if (which == 2 ){

                            Intent intent = new Intent(context, MatchSummaryActivity.class);
                            intent.putExtra("match_id",matchId);
                            intent.putExtra("match_type", matchType);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);

                        }
//                        if (which == 3){
//
//                            if (matchStatus.equals("true")) {
//                                Intent intent = new Intent(context, HighlightsActivity.class);
//                                intent.putExtra("team1", team1);
//                                intent.putExtra("team2", team2);
//                                intent.putExtra("date", date);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                context.startActivity(intent);
//                            }
//                            else {
//                                Toast.makeText(context, "Sorry :( \nThis match hasn't started", Toast.LENGTH_SHORT).show();
//                            }
//                        }
                    }
                });
                builder.create().show();

//                Intent intent = new Intent(context, MatchDetailActivity.class);
//                intent.putExtra("match_id",matchId);
//                intent.putExtra("date",date);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView team1TV, team2TV, matchTypeTV, matchStatusTV, venueTV, dateTV;
        ImageView team1Logo, team2Logo;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            team1TV = itemView.findViewById(R.id.team1TV);
            team2TV = itemView.findViewById(R.id.team2TV);
            matchTypeTV = itemView.findViewById(R.id.matchTypeTV);
            matchStatusTV = itemView.findViewById(R.id.matchStatusTV);
            venueTV = itemView.findViewById(R.id.venueTV);
            dateTV = itemView.findViewById(R.id.dateTV);
            team1Logo = itemView.findViewById(R.id.team1Logo);
            team2Logo = itemView.findViewById(R.id.team2Logo);
            cardView =itemView.findViewById(R.id.cardView);
        }
    }

}

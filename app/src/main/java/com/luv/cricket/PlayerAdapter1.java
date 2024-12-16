package com.luv.cricket;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PlayerAdapter1 extends RecyclerView.Adapter<PlayerAdapter1.ViewHolder>{
    private static ArrayList<PlayerModel1> playerModelList = new ArrayList<>();
    private Context context;

    public PlayerAdapter1(ArrayList<PlayerModel1> playerModelList, Context context){
        if(!PlayerAdapter1.playerModelList.isEmpty()){
            PlayerAdapter1.playerModelList.clear();
        }
        PlayerAdapter1.playerModelList = playerModelList;
        this.context = context;
//        updatePlayers(playerModelList);
    }

    @NonNull
    @Override
    public PlayerAdapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.players_row, viewGroup, false);
        return new PlayerAdapter1.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PlayerModel1 playerModel = playerModelList.get(position);
        holder.player_name.setText(playerModel.getPlayer_name());
        if(!playerModel.getPlayer_image().equals("https://cdorgapi.b-cdn.net/img/icon512.png")) {
            Glide.with(context).load(playerModel.getPlayer_image()).into(holder.player_image);
        }
        holder.player_details.setText(playerModel.getPlayer_details());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String playerID = playerModel.getPlayer_id();
                String[] options = {"Player Info"};
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());
                builder.setTitle("Choose Option");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which == 0){

                            Intent intent = new Intent(context, PlayerInfoActivity.class);
                            intent.putExtra("player_id", playerID);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);

                        }
                    }
                });
                builder.create().show();
            }
        });
    }

    public static RecyclerView.Adapter updatePlayers(ArrayList<PlayerModel1> updatedPlayer) {
        if(!playerModelList.isEmpty()) {
            playerModelList.clear();
        }
        playerModelList.addAll(updatedPlayer);
        return null;
    }

    @Override
    public int getItemCount() {
        return playerModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView player_name, player_details;
        ImageView player_image;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            player_name = itemView.findViewById(R.id.playerName);
            player_image = itemView.findViewById(R.id.player_image);
            player_details = itemView.findViewById(R.id.playerDetails);
            cardView = itemView.findViewById(R.id.playersCardView);
        }
    }
}

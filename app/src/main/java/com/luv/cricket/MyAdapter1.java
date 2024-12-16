package com.luv.cricket;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder> {


    private List<Model> modelList;
    private Context context;

    public MyAdapter1(List<Model> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Model model = modelList.get(position);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to set this team as your favourite?(You will get notifications every time this team's match is played)");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0){

                            Intent intent = new Intent(context, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                        }
                        if (which == 1){

                            Intent intent = new Intent(context,SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                        }
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        String australia, india, westIndies, pakistan, sriLanka, southAfrica, newZealand, zimbabawe, afganistan, bangladesh,
                ireland, nambia, unitedArabEmirates, england, scotland, canada, kenya, papuaNewGuinea, nepal, unitedStates, netherlands, qatar, wales, hongKong;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            australia = Model.getAustralia();
            india = Model.getIndia();
            westIndies = Model.getWestIndies();
            pakistan = Model.getPakistan();
            sriLanka = Model.getSriLanka();
            southAfrica = Model.getSouthAfrica();
            newZealand = Model.getNewZealand();
            zimbabawe = Model.getZimbabawe();
            afganistan = Model.getAfganistan();
            bangladesh = Model.getBangladesh();
            ireland = Model.getIreland();
            nambia = Model.getNambia();
            unitedArabEmirates = Model.getUnitedArabEmirates();
            england = Model.getEngland();
            scotland = Model.getScotland();
            canada = Model.getCanada();
            kenya = Model.getKenya();
            papuaNewGuinea = Model.getPapuaNewGuinea();
            nepal = Model.getNepal();
            unitedStates = Model.getUnitedStates();
            netherlands = Model.getNetherlands();
            qatar = Model.getQatar();
            wales = Model.getWales();
            hongKong = Model.getHongKong();

            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}

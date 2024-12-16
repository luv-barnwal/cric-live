package com.luv.cricket;

public class PlayerModel {
    private String player_id, player_name, player_image, player_details;

    public PlayerModel(String player_id, String player_name, String player_image, String player_details){
        this.player_id = player_id;
        this.player_name = player_name;
        this.player_image = player_image;
        this.player_details = player_details;
    }

    public String getPlayer_id(){
        return player_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public String getPlayer_image() {
        return player_image;
    }

    public String getPlayer_details() {
        return player_details;
    }
}

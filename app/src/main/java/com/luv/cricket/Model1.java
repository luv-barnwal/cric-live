package com.luv.cricket;

class Model1 {

    private String id, team1, team2, matchStatus, matchType, venue, date, team1Image, team2Image;

    public Model1(String id, String team1, String team2, String matchStatus, String matchType, String venue, String date, String team1Image, String team2Image){
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.matchStatus = matchStatus;
        this.matchType = matchType;
        this.venue = venue;
        this.date = date;
        this.team1Image = team1Image;
        this.team2Image = team2Image;
    }

    public String getId() {
        return id;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getMatchType() {
        return matchType;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public String getVenue() {
        return venue;
    }

    public String getDate() {
        return date;
    }

    public String getTeam1Image() {
        return team1Image;
    }

    public String getTeam2Image() {
        return team2Image;
    }
}

package com.fivethirtyeight.predictionapp;

public class State {

    private String leader;
    private String state;
    private String winprob;
    private String image;

    public State() {
        // TODO Auto-generated constructor stub
    }

    public State(String leader, String state,
                 String winprob, String image) {
        super();
        this.leader = leader;
        this.state = state;
        this.winprob = winprob;
        this.image = image;
    }


    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getState() {
        return state;
    }

    public void setState(String country) {
        this.state = state;
    }

    public String getWinprob() {
        return winprob;
    }

    public void setWinprob(String height) {
        this.winprob = winprob;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
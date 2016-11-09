package com.fivethirtyeight.predictionapp.models;

/**
 * Created on 11/1/2016.
 */

public class PlusModel {

    private String state;
    private String winprob;
    private String Candidate;
    private String sentences;
    private String plus;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWinprob() {
        return winprob;
    }

    public void setWinprob(String winprob) {
        this.winprob = winprob;
    }

    public String getCandidate() {
        return Candidate;
    }

    public void setCandidate(String candidate) {
        Candidate = candidate;
    }

    public String getSentences() {
        return sentences;
    }

    public void setSentences(String sentences) {
        this.sentences = sentences;
    }

    public String getPlus() {
        return plus;
    }

    public void setPlus(String plus) {
        this.plus = plus;
    }



}

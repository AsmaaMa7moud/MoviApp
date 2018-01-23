package com.m.m.asmaa.movies.model;

/**
 * Created by hp on 04/11/2016.
 */

public class modelmovie {
    private String title;
    private String poster_path;
    private String overview ;
    private String vote_average ;
    private String date ;
    String type;

    public modelmovie(String title, String poster_path, String overview, String date, String type, String vote_average) {
        this.title = title;
        this.poster_path = poster_path;
        this.date = date;
        this.overview = overview;
        this.type = type;
        this.vote_average = vote_average;
    }
    public modelmovie() {

    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {

        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path =poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

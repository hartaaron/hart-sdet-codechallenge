package com.hart.android.ui.pageobjects.rottentomatoes;

/**
 * Created by sushil.mayer on 12/10/2015.
 */
public class Movie {

    String title;
    String director;
    String audinceScore;
    String tatometer;
    String rating;
    String summary;
    Long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getAudinceScore() {
        return audinceScore;
    }

    public void setAudinceScore(String audinceScore) {
        this.audinceScore = audinceScore;
    }

    public String getTatometer() {
        return tatometer;
    }

    public void setTatometer(String tatometer) {
        this.tatometer = tatometer;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

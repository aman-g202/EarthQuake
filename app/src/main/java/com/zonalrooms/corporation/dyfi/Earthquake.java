package com.zonalrooms.corporation.dyfi;

/**
 * Created by DELL on 6/11/2017.
 */

public class Earthquake {
    private String title, people, value, url;

    public Earthquake() {
    }

    public Earthquake(String title, String people, String value, String url) {
        this.title = title;
        this.people = people;
        this.value = value;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

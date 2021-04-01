package com.example.edith.model;

public class MeatContents {

    Integer id;
    String name;
    int imageurl;
    int progressurl;

    public MeatContents(Integer id, int imageurl, int progressurl, String name) {
        this.id = id;
        this.imageurl = imageurl;
        this.progressurl = progressurl;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }

    public int getProgressurl() {
        return progressurl;
    }

    public void setProgressurl(int progressurl) {
        this.progressurl = progressurl;
    }

    public String getname() {return name;}

    public void setname(String name){this.name = name;}

}
package com.example.mechanicalproject;

public class About_Us {

    String About;
    int image;

    public About_Us(String about, int image) {
        About = about;
        this.image = image;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

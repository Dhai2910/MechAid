package com.example.mechanicalproject;

public class menu {
    String text;
    int back;
    int img;

    public menu(String text, int back, int img) {
        this.text = text;
        this.back = back;
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getBack() {
        return back;
    }

    public void setBack(int back) {
        this.back = back;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

package com.example.josedecorea.myapplication99;

/**
 * Created by jose de corea on 2017-02-06.
 */

public class ListHelloItem{

    private int iconDrawable;
    private String titleStr ;
    private String subStr;
    private String audioStr;

    public void setIcon(int icon) {
        iconDrawable = icon;
    }
    public void setTitle(String title) {
        titleStr = title;
    }
    public void setSub(String sub) {
        subStr = sub;
    }
    public void setAudio(String audio) {
        audioStr = audio;
    }


    public int getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getSub() {
        return this.subStr ;
    }
    public String getAudio() {
        return this.audioStr ;
    }

}
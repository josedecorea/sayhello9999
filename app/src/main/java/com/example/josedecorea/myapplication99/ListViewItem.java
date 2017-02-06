package com.example.josedecorea.myapplication99;

/**
 * Created by jose de corea on 2017-02-05.
 */

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private int iconDrawable;
    private String titleStr ;

    public void setIcon(int icon) {
        iconDrawable = icon;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }

    public int getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }

}
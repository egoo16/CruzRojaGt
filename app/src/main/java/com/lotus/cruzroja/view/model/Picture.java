package com.lotus.cruzroja.view.model;

import android.graphics.drawable.Drawable;

/**
 * Created by lotus on 14/08/17.
 */

public class Picture {
    private int picture;
    private String Title;
    private String Subtitle;

    public Picture(int picture, String title, String subtitle) {
        this.picture = picture;
        Title = title;
        Subtitle = subtitle;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSubtitle() {
        return Subtitle;
    }

    public void setSubtitle(String subtitle) {
        Subtitle = subtitle;
    }
}



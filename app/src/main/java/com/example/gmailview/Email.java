package com.example.gmailview;

import android.content.res.ColorStateList;
import android.graphics.Color;

import java.util.Date;
import java.util.Random;

public class Email {
    private String name;
    private String previewText;
    private Date date;
    private boolean highlighted;
    private ColorStateList color;

    public Email(String name, String previewText, Date date, boolean highlighted) {
        this.name = name;
        this.previewText = previewText;
        this.date = date;
        this.highlighted = highlighted;
        Random rnd = new Random();
        this.color = ColorStateList.valueOf(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreviewText() {
        return previewText;
    }

    public void setPreviewText(String previewText) {
        this.previewText = previewText;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isHighlighted() {
        return highlighted;
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }

    public ColorStateList getColor() {
        return color;
    }

    public int getTextColor() {
        double y = (299 * Color.red(color.getDefaultColor()) + 587 * Color.green(color.getDefaultColor()) + 114 * Color.blue(color.getDefaultColor())) / 1000;
        return y >= 128 ? Color.BLACK : Color.WHITE;
    }
}

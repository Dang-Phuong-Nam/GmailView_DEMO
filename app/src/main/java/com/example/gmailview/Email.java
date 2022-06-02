package com.example.gmailview;

import java.util.Date;

public class Email {
    private String name;
    private String previewText;
    private Date date;
    private boolean highlighted;

    public Email(String name, String previewText, Date date, boolean highlighted) {
        this.name = name;
        this.previewText = previewText;
        this.date = date;
        this.highlighted = highlighted;
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
}

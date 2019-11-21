package com.moringa.tracks;

public class News {
    String title, description;

    public News(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public News(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

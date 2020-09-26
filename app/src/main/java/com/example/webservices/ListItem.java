package com.example.webservices;

public class ListItem {
    private String title;
    private String subtitle1;
    private String subtitle2;

    public ListItem(String title, String subtitle1, String subtitle2) {
        this.title = title;
        this.subtitle1 = subtitle1;
        this.subtitle2 = subtitle2;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle1() {
        return subtitle1;
    }

    public String getSubtitle2() {
        return subtitle2;
    }
}

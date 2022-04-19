package com.cookandroid.modori;

public class Modori {
    String title;
    String contents;

    public Modori(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public String getTitle() {
        return title;
    }
}

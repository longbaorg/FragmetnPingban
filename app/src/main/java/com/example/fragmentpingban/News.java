package com.example.fragmentpingban;

/**
 * Created by longbao on 2019/5/8.
 */

public class News {

    private String title;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News (String title, String content) {
        this.title = title;
        this.content = content;
    }

}

package com.zucc.demo.model;

/**
 * Created by hxu on 7/2/17.
 */
public class WikiPageVo {
    private static final long serialVersionUID = 1L;

    private String title;
    private String url;
    private String abstracts;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }
}

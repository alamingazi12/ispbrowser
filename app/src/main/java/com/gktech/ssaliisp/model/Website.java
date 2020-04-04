package com.gktech.ssaliisp.model;

public class Website {

    public Website(String name, int imageid, String url) {
        this.name = name;
        this.imageid = imageid;
        this.url = url;
    }

    String name;
    int imageid;
    String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package com.nsc.apk.herb4health.Model;

/**
 * Created by Non on 12/4/2017.
 */

public class Food {
    public String title,summary,url;
    public int imgF;

    public Food(String title,String summary,int imgF){

        this.title = title;
        this.summary = summary;
        this.imgF = imgF;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getImgF() {
        return imgF;
    }

    public void setImgF(int imgF) {
        this.imgF = imgF;
    }
}

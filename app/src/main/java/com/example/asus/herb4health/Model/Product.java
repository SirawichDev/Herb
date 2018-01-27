package com.example.asus.herb4health.Model;

/**
 * Created by Non on 1/9/2018.
 */

public class Product {
    public String titlePd,summaryPd;
    public int imgPd;

    public Product(String titlePd,String summaryPd,int imgPd){
        this.titlePd = titlePd;
        this.summaryPd =summaryPd;
        this.imgPd =imgPd;
    }

    public String getTitlePd() {
        return titlePd;
    }

    public void setTitlePd(String titlePd) {
        this.titlePd = titlePd;
    }

    public String getSummaryPd() {
        return summaryPd;
    }

    public void setSummaryPd(String summaryPd) {
        this.summaryPd = summaryPd;
    }

    public int getImgPd() {
        return imgPd;
    }

    public void setImgPd(int imgPd) {
        this.imgPd = imgPd;
    }
}

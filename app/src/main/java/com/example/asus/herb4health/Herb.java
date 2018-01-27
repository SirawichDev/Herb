package com.example.asus.herb4health;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Non on 9/7/2017.
 */

public class Herb {
    private String breed;
    private String drescription;
    private int resId;
    private List<Herb> herbList = new ArrayList<>();
    Herb(){

    }
    Herb(int resId,String breed,String drescription){
        this.resId = resId;
        this.breed = breed;
        this.drescription =drescription;
    }


    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDrescription() {
        return drescription;
    }

    public void setDrescription(String drescription) {
        this.drescription = drescription;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public List<Herb> getHerbList() {
        return herbList;
    }

    public void setHerbList(List<Herb> herbList) {
        this.herbList = herbList;
    }
}


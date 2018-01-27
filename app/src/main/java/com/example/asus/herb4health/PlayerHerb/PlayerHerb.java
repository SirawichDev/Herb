package com.example.asus.herb4health.PlayerHerb;

/**
 * Created by Non on 10/22/2017.
 */

public class PlayerHerb {


    private String name;
    private String name2;
    private String opt;
    private String how;
    private String eff;
    private int img;


    //Name
    public String getNameHerb() {
        return name;
    }


    public void setNameHerb(String name) {
        this.name = name;
    }
    //OtherName 2
    public String getNameHerb2(){
        return name2;
    }
    public  void  setNameHerb2(String name2){
        this.name2 = name2;
    }
    //Option
    public String getOpt() {
        return opt;
    }
    public void setOpt(String opt) {
        this.opt = opt;
    }
    //How To
    public String getHow() {
        return how;
    }
    public void setHow(String how) {
        this.how = how;
    }

    //Effect
    public String getEff() {
        return eff;
    }
    public void setEff(String eff) {
        this.eff = eff;
    }
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

}

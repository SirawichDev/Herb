package com.example.asus.herb4health;

/**
 * Created by sirawich on 9/2/2017 AD.
 */

public class ImageUploadConfig {
    public String name;
    public String name2;
    public String url;
    public String option;
    public String option1;
    public String option2;
    public String getname(){
        return name;

    }
    public String getName2()
    {
        return name2;
    }
    public String getOption(){
        return option;
    }
    public String getOption1(){
        return option1;
    }
    public String getOption2(){
        return option2;
    }
    public String geturl(){
        return url;
    }
    public ImageUploadConfig(String name ,String name2, String url, String option, String option1, String option2){
        this.name = name;
        this.name2 = name2;
        this.url = url;
        this.option = option;
        this.option1 = option1;
        this.option2 = option2;

    }
    public ImageUploadConfig(){}
}

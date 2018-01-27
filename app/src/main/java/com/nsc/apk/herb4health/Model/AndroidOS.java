package com.nsc.apk.herb4health.Model;

import android.os.Parcel;
import android.os.Parcelable;


public class AndroidOS implements Parcelable{
    public String name;
    public int spc_int;
    public String version;

    public String description;
    public String image_url;
    public String icon_url;

    public AndroidOS(){}

    private AndroidOS(Parcel in){
        name = in.readString();
        version = in.readString();
        description = in.readString();
        image_url = in.readString();
        icon_url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(version);
        dest.writeString(description);
        dest.writeString(image_url);
        dest.writeString(icon_url);
    }

    public static final Creator<AndroidOS> CREATOR = new Creator<AndroidOS>() {
        @Override
        public AndroidOS createFromParcel(Parcel source) {
            return new AndroidOS(source);
        }

        @Override
        public AndroidOS[] newArray(int size) {
            return new AndroidOS[size];
        }
    };

}

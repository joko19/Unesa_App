package com.example.unesa.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Gallery implements Parcelable {
    private String img;

    public Gallery() {
    }

    public Gallery(String img) {
        this.img = img;
    }

    protected Gallery(Parcel in) {
        img = in.readString();
    }

    public static final Creator<Gallery> CREATOR = new Creator<Gallery>() {
        @Override
        public Gallery createFromParcel(Parcel in) {
            return new Gallery(in);
        }

        @Override
        public Gallery[] newArray(int size) {
            return new Gallery[size];
        }
    };

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(img);
    }
}

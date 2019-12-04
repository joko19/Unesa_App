package com.example.unesa.model;

import android.os.Parcel;
import android.os.Parcelable;

//import com.google.firebase.firestore.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Berita implements Parcelable {
    private String title, img_url, konten;

    public Berita() {
    }

    public Berita(String title, String img_url, String konten) {
        this.title = title;
        this.img_url = img_url;
        this.konten = konten;
    }

    protected Berita(Parcel in) {
        title = in.readString();
        img_url = in.readString();
        konten = in.readString();
    }

    public static final Creator<Berita> CREATOR = new Creator<Berita>() {
        @Override
        public Berita createFromParcel(Parcel in) {
            return new Berita(in);
        }

        @Override
        public Berita[] newArray(int size) {
            return new Berita[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(img_url);
        dest.writeString(konten);
    }

//    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("judul", title);
        result.put("gambar", img_url);
        result.put("isi", konten);
        return result;
    }
}

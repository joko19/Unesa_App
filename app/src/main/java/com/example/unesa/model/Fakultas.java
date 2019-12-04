package com.example.unesa.model;

public class Fakultas {

    private String nama, gambar, visi, misi;

    public Fakultas() {
    }

    public Fakultas(String nama, String gambar, String visi, String misi) {
        this.nama = nama;
        this.gambar = gambar;
        this.visi = visi;
        this.misi = misi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getVisi() {
        return visi;
    }

    public void setVisi(String visi) {
        this.visi = visi;
    }

    public String getMisi() {
        return misi;
    }

    public void setMisi(String misi) {
        this.misi = misi;
    }
}

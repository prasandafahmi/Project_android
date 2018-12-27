package com.example.rakafirmansyahpramono.portalberitacnn;

public class DataFilter {
    private String Judul;
    private String Edisi;
    private String Penulis;

    DataFilter(String Judul, String Edisi, String Penulis) {
        this.Judul = Judul;
        this.Edisi = Edisi;
        this.Penulis = Penulis;
    }

    public String getJudul() {
        return Judul;
    }

    public String getEdisi() {
        return Edisi;
    }

    public String getPenulis() {
        return Penulis;
    }

}

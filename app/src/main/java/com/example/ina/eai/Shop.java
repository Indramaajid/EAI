package com.example.ina.eai;

/**
 * Created by INA on 10/3/2017.
 */

public class Shop {
    private String nama_produk;
    private String harga_produk;
    private int thumbnail;

    public Shop() {

    }

    public Shop(String nama_produk, String harga_produk, int thumbnail) {
        this.nama_produk = nama_produk;
        this.harga_produk = harga_produk;
        this.thumbnail = thumbnail;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public void setHarga_produk(String harga_produk) {
        this.harga_produk = harga_produk;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getNama_produk() {

        return nama_produk;
    }

    public String getHarga_produk() {
        return harga_produk;
    }

    public int getThumbnail() {
        return thumbnail;
    }
}

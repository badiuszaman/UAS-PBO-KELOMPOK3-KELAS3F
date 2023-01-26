/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uas.model;

/**
 *
 * @author HP
 */
public class Transaksi {
     private String kode_transaksi;
  
    private String nama_pembeli;
      private String no_hp;
        private String alamat;
          private String kode_motor;
           private String kode_pembeli;

    public String getKode_pembeli() {
        return kode_pembeli;
    }

    public void setKode_pembeli(String kode_pembeli) {
        this.kode_pembeli = kode_pembeli;
    }
           
            private String merk;
              private String warna;
                private String harga;
                  private String tanggal;

    public String getKode_transaksi() {
        return kode_transaksi;
    }

    public void setKode_transaksi(String kode_transaksi) {
        this.kode_transaksi = kode_transaksi;
    }

    public String getNama_pembeli() {
        return nama_pembeli;
    }

    public void setNama_pembeli(String nama_pembeli) {
        this.nama_pembeli = nama_pembeli;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKode_motor() {
        return kode_motor;
    }

    public void setKode_motor(String kode_motor) {
        this.kode_motor = kode_motor;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}

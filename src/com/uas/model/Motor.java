/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uas.model;

/**
 *
 * @author senja
 */
public class Motor {
        private String kode_motor;
    private String merk_motor;
    private String warna;

    public String getKode_motor() {
        return kode_motor;
    }

    public void setKode_motor(String kode_motor) {
        this.kode_motor = kode_motor;
    }

    public String getMerk_motor() {
        return merk_motor;
    }

    public void setMerk_motor(String merk_motor) {
        this.merk_motor = merk_motor;
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
  private String harga;
}

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
public class Pembeli {
      private String kode_pembeli;
    private String nama_pembeli;
    private String no_hp;
  private String alamat;

    public String getKode_pembeli() {
        return kode_pembeli;
    }

    public void setKode_pembeli(String kode_pembeli) {
        this.kode_pembeli = kode_pembeli;
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
  
  
}

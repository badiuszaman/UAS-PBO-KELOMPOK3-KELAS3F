/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uas.dao;

import com.uas.koneksi.DBConnection;
import com.uas.model.Transaksi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class TransaksiDAO {
     public List<Transaksi> getAll() {
        java.sql.Connection conn = new DBConnection().connect();
        List<Transaksi> tr = null;
        try {
            tr = new ArrayList<>();
            String sql = "SELECT transaksi.kode_transaksi,pembeli.kode_pembeli,pembeli.nama_pembeli,pembeli.no_hp,pembeli.alamat,motor.kode_motor,motor.merk_motor,motor.warna,motor.harga,transaksi.tanggal FROM \n" +
"motor JOIN transaksi ON motor.kode_motor=transaksi.kode_motor JOIN pembeli ON transaksi.kode_pembeli=pembeli.kode_pembeli";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                Transaksi t = new Transaksi();
                t.setKode_transaksi(rslt.getString("kode_transaksi"));
                 t.setKode_pembeli(rslt.getString("kode_pembeli"));
                t.setNama_pembeli(rslt.getString("nama_pembeli"));
                t.setNo_hp(rslt.getString("no_hp"));
               t.setAlamat(rslt.getString("alamat"));
                  t.setKode_motor(rslt.getString("kode_motor"));
                     t.setMerk(rslt.getString("merk_motor"));
                        t.setWarna(rslt.getString("warna"));
                           t.setHarga(rslt.getString("harga"));
                              t.setTanggal(rslt.getString("tanggal"));
                tr.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return tr;

    }
     
    
         public Transaksi save(Transaksi transaki) {
        java.sql.Connection conn = new DBConnection().connect();
       
        try {
            String sql = "insert into transaksi(kode_transaksi,kode_pembeli,kode_motor,tanggal ) values(?,?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);

            try {
                stmt.setString(1, transaki.getKode_transaksi());
                stmt.setString(2, transaki.getKode_pembeli());
                stmt.setString(3, transaki.getKode_motor());
                stmt.setString(4, transaki.getTanggal());
               
              //  stmt.setString(7, tanggal);

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di simpan");

            } catch (SQLException se) {
                System.out.println("Error = " + se);
                JOptionPane.showMessageDialog(null, "Data Gagal di simpan" );
            }
            stmt.close();
        } catch (Exception e) {
                System.out.println("Error = " + e);
        }
        return transaki;

    }
        public Transaksi getKode_transaksi(Transaksi t) {
        java.sql.Connection conn = new DBConnection().connect();
        try {
            String sql = "SELECT transaksi.kode_transaksi,pembeli.kode_pembeli,pembeli.nama_pembeli,pembeli.no_hp,pembeli.alamat,motor.kode_motor,motor.merk_motor,motor.warna,motor.harga,transaksi.tanggal FROM \n" +
"motor JOIN transaksi ON motor.kode_motor=transaksi.kode_motor JOIN pembeli ON transaksi.kode_pembeli=pembeli.kode_pembeli where kode_transaksi='"+t.getKode_transaksi()+"'";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                t = new Transaksi();
                t.setKode_transaksi(rslt.getString("kode_transaksi"));
                t.setKode_pembeli(rslt.getString("kode_pembeli"));
                t.setKode_motor(rslt.getString("kode_motor"));
            t.setNama_pembeli(rslt.getString("nama_pembeli"));
              t.setMerk(rslt.getString("merk_motor"));
                t.setWarna(rslt.getString("warna"));
                t.setHarga(rslt.getString("harga"));
            }
           
           
          
           
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return t;

    }
        public Transaksi getKode_Pembeli(Transaksi t) {
        java.sql.Connection conn = new DBConnection().connect();
        try {
            String sql = "Select * from pembeli where kode_pembeli='"+t.getKode_pembeli()+"'";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                t = new Transaksi();
                t.setNama_pembeli(rslt.getString("nama_pembeli"));
                t.setNo_hp(rslt.getString("no_hp"));
                t.setAlamat(rslt.getString("alamat"));
          
            }
           
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return t;

    }
          public Transaksi update(Transaksi transaksi) {
        java.sql.Connection conn = new DBConnection().connect();

        try {
            String sql = "update transaksi set kode_pembeli=?,kode_motor=?,tanggal=? where kode_transaksi=?";
            java.sql.PreparedStatement update = conn.prepareStatement(sql);

            try {
                update.setString(1, transaksi.getKode_pembeli());
                update.setString(2, transaksi.getKode_motor());
                update.setString(3, transaksi.getTanggal());
                update.setString(4, transaksi.getKode_transaksi());
                update.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di ubah");

            } catch (SQLException se) {
                System.out.println("Error = " + se);
                JOptionPane.showMessageDialog(null, "Data Gagal di ubah");
            }
            update.close();
        } catch (Exception e) {
        }
        return transaksi;
    }
             public Transaksi delete(Transaksi transaksi) {
        java.sql.Connection conn = new DBConnection().connect();

        try {
            String sql = "delete from transaksi where kode_transaksi=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);

            try {
                stmt.setString(1, transaksi.getKode_transaksi());

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di hapus");

            } catch (SQLException se) {
                System.out.println("Error = " + se);
                JOptionPane.showMessageDialog(null, "Data Gagal di hapus");
            }
            stmt.close();
        } catch (Exception e) {
        }
        return transaksi;

    }
       public List<Transaksi> searching(String teks) {
        java.sql.Connection conn = new DBConnection().connect();
        List<Transaksi> trs = null;
        try {
            trs = new ArrayList<>();
            String sql = "Select * from pembeli where kode_transaksi like ? OR kode_pembeli like ?";
            java.sql.PreparedStatement cari = conn.prepareStatement(sql);
            cari.setString(1, "%" + teks + "%");
            cari.setString(2, "%" + teks + "%");
            java.sql.ResultSet rslt = cari.executeQuery();
            while (rslt.next()) {
                  Transaksi t = new Transaksi();
                t.setKode_transaksi(rslt.getString("kode_transaksi"));
                t.setKode_pembeli(rslt.getString("kode_pembeli"));
                t.setKode_motor(rslt.getString("kode_motor"));
              t.setTanggal(rslt.getString("tanggal"));
                
                
                trs.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return trs;
    }
       
     
     
     
     
     
     
     
     
     
     
     
     
     
}

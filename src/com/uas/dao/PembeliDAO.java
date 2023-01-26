/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uas.dao;

import com.uas.koneksi.DBConnection;
import com.uas.model.Pembeli;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author senja
 */
public class PembeliDAO {
     public List<Pembeli> getAll() {
        java.sql.Connection conn = new DBConnection().connect();
        List<Pembeli> pmb = null;
        try {
            pmb = new ArrayList<>();
            String sql = "SELECT * FROM pembeli";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                Pembeli p = new Pembeli();
                p.setKode_pembeli(rslt.getString("kode_pembeli"));
                p.setNama_pembeli(rslt.getString("nama_pembeli"));
                p.setNo_hp(rslt.getString("no_hp"));
               p.setAlamat(rslt.getString("alamat"));
                 
                pmb.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return pmb;

    }
       public Pembeli getKode_pembeli(Pembeli p) {
        java.sql.Connection conn = new DBConnection().connect();
        try {
            String sql = "Select * from pembeli where kode_pembeli='"+p.getKode_pembeli()+"'";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                p = new Pembeli();
                p.setKode_pembeli(rslt.getString("kode_pembeli"));
                p.setNama_pembeli(rslt.getString("nama_pembeli"));
           
             
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return p;

    }
         public Pembeli save(Pembeli pembeli) {
        java.sql.Connection conn = new DBConnection().connect();
       
        try {
            String sql = "insert into pembeli(kode_pembeli,nama_pembeli,no_hp, alamat ) values(?,?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);

            try {
                stmt.setString(1, pembeli.getKode_pembeli());
                stmt.setString(2, pembeli.getNama_pembeli());
                stmt.setString(3, pembeli.getNo_hp());
                stmt.setString(4, pembeli.getAlamat());
               
              //  stmt.setString(7, tanggal);

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di simpan");

            } catch (SQLException se) {
                System.out.println("Error = " + se);
                JOptionPane.showMessageDialog(null, "Data Gagal di simpan");
            }
            stmt.close();
        } catch (Exception e) {
                System.out.println("Error = " + e);
        }
        return pembeli;

    }
        public Pembeli getID(Pembeli p) {
        java.sql.Connection conn = new DBConnection().connect();
        try {
            String sql = "Select * from pembeli where kode_pembeli='"+p.getKode_pembeli()+"'";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                p = new Pembeli();
                p.setKode_pembeli(rslt.getString("kode_pembeli"));
                p.setNama_pembeli(rslt.getString("nama_pembeli"));
                p.setNo_hp(rslt.getString("no_hp"));
              p.setAlamat(rslt.getString("alamat"));
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return p;

    }
          public Pembeli update(Pembeli pembeli) {
        java.sql.Connection conn = new DBConnection().connect();

        try {
            String sql = "update pembeli set nama_pembeli=?,no_hp=?,alamat=? where kode_pembeli=?";
            java.sql.PreparedStatement update = conn.prepareStatement(sql);

            try {
                update.setString(1, pembeli.getNama_pembeli());
                update.setString(2, pembeli.getNo_hp());
                update.setString(3, pembeli.getAlamat());
                update.setString(4, pembeli.getKode_pembeli());
                update.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di ubah");

            } catch (SQLException se) {
                System.out.println("Error = " + se);
                JOptionPane.showMessageDialog(null, "Data Gagal di ubah");
            }
            update.close();
        } catch (Exception e) {
        }
        return pembeli;
    }
             public Pembeli delete(Pembeli pembeli) {
        java.sql.Connection conn = new DBConnection().connect();

        try {
            String sql = "delete from pembeli where kode_pembeli=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);

            try {
                stmt.setString(1, pembeli.getKode_pembeli());

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di hapus");

            } catch (SQLException se) {
                System.out.println("Error = " + se);
                JOptionPane.showMessageDialog(null, "Data Gagal di hapus");
            }
            stmt.close();
        } catch (Exception e) {
        }
        return pembeli;

    }
       public List<Pembeli> searching(String teks) {
        java.sql.Connection conn = new DBConnection().connect();
        List<Pembeli> pmb = null;
        try {
            pmb = new ArrayList<>();
            String sql = "Select * from pembeli where kode_pembeli like ? OR nama_pembeli like ?";
            java.sql.PreparedStatement cari = conn.prepareStatement(sql);
            cari.setString(1, "%" + teks + "%");
            cari.setString(2, "%" + teks + "%");
            java.sql.ResultSet rslt = cari.executeQuery();
            while (rslt.next()) {
                  Pembeli p = new Pembeli();
                p.setKode_pembeli(rslt.getString("kode_pembeli"));
                p.setNama_pembeli(rslt.getString("nama_pembeli"));
                p.setNo_hp(rslt.getString("no_hp"));
              p.setAlamat(rslt.getString("alamat"));
                
                
                pmb.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return pmb;
    }
       
       
}

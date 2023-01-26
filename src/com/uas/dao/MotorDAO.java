/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uas.dao;

import com.uas.koneksi.DBConnection;
import com.uas.model.Motor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author senja
 */
public class MotorDAO {
      public List<Motor> getAll() {
        java.sql.Connection conn = new DBConnection().connect();
        List<Motor> mtr = null;
        try {
            mtr = new ArrayList<>();
            String sql = "SELECT * FROM motor";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                Motor m = new Motor();
                m.setKode_motor(rslt.getString("kode_motor"));
                m.setMerk_motor(rslt.getString("merk_motor"));
                m.setWarna(rslt.getString("warna"));
               m.setHarga(rslt.getString("harga"));
                 
                mtr.add(m);
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return mtr;

    }
        public Motor getKode_motor(Motor m) {
        java.sql.Connection conn = new DBConnection().connect();
        try {
            String sql = "Select * from motor where kode_motor='"+m.getKode_motor()+"'";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                m = new Motor();
                m.setKode_motor(rslt.getString("kode_motor"));
                m.setMerk_motor(rslt.getString("merk_motor"));
            m.setWarna(rslt.getString("warna"));
             m.setHarga(rslt.getString("harga"));
             
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return m;

    }
              
         public Motor save(Motor motor) {
        java.sql.Connection conn = new DBConnection().connect();
       
        try {
            String sql = "insert into motor(kode_motor,merk_motor,warna,harga ) values(?,?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);

            try {
                stmt.setString(1, motor.getKode_motor());
                stmt.setString(2, motor.getMerk_motor());
                stmt.setString(3, motor.getWarna());
                stmt.setString(4, motor.getHarga());
               
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
        return motor;

    }
        public Motor getID(Motor m) {
        java.sql.Connection conn = new DBConnection().connect();
        try {
            //kode_motor,merk_motor,warna,harga
            String sql = "Select * from motor where kode_motor='"+m.getKode_motor()+"'";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                m = new Motor();
                m.setKode_motor(rslt.getString("kode_motor"));
                m.setMerk_motor(rslt.getString("merk_motor"));
                m.setWarna(rslt.getString("warna"));
              m.setHarga(rslt.getString("harga"));
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return m;

    }
          public Motor update(Motor motor) {
        java.sql.Connection conn = new DBConnection().connect();

        try {
            String sql = "update motor set merk_motor=?,warna=?,harga=? where kode_motor=?";
            java.sql.PreparedStatement update = conn.prepareStatement(sql);

            try {
                  //kode_motor,merk_motor,warna,harga
                update.setString(1, motor.getMerk_motor());
                update.setString(2, motor.getWarna());
                update.setString(3, motor.getHarga());
                update.setString(4, motor.getKode_motor());
                update.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di ubah");

            } catch (SQLException se) {
                System.out.println("Error = " + se);
                JOptionPane.showMessageDialog(null, "Data Gagal di ubah");
            }
            update.close();
        } catch (Exception e) {
        }
        return motor;
    }
             public Motor delete(Motor motor) {
        java.sql.Connection conn = new DBConnection().connect();

        try {
            
            String sql = "delete from motor where kode_motor=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);

            try {
                stmt.setString(1, motor.getKode_motor());

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di hapus");

            } catch (SQLException se) {
                System.out.println("Error = " + se);
                JOptionPane.showMessageDialog(null, "Data Gagal di hapus");
            }
            stmt.close();
        } catch (Exception e) {
        }
        return motor;

    }
       public List<Motor> searching(String teks) {
        java.sql.Connection conn = new DBConnection().connect();
        List<Motor> mtr = null;
        try {
            mtr = new ArrayList<>();
            //kode_motor,merk_motor,warna,harga
            String sql = "Select * from motor where kode_motor like ? OR merk_motor like ?";
            java.sql.PreparedStatement cari = conn.prepareStatement(sql);
            cari.setString(1, "%" + teks + "%");
            cari.setString(2, "%" + teks + "%");
            java.sql.ResultSet rslt = cari.executeQuery();
            while (rslt.next()) {
                  Motor m = new Motor();
                m.setKode_motor(rslt.getString("kode_motor"));
                m.setMerk_motor(rslt.getString("merk_motor"));
                m.setWarna(rslt.getString("warna"));
              m.setHarga(rslt.getString("harga"));
                
                
                mtr.add(m);
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return mtr;
    }
       
        
        
        
        
        
}

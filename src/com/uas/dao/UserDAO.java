/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uas.dao;

import com.uas.koneksi.DBConnection;
import com.uas.model.User;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author senja
 */

public class UserDAO {
     public List<User> getAll() {
        java.sql.Connection conn = new DBConnection().connect();
        List<User> us = null;
        try {
            us = new ArrayList<>();
            String sql = "SELECT transaksi.kode_transaksi,pembeli.nama_pembeli,pembeli.no_hp,pembeli.alamat,motor.kode_motor,motor.merk,motor.warna,motor.harga,transaksi.tanggal FROM \n" +
"motor JOIN transaksi ON motor.kode_motor=transaksi.kode_motor JOIN pembeli ON transaksi.id_pembeli=pembeli.id_pembeli";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                User u = new User();
                u.setKode_transaksi(rslt.getString("kode_transaksi"));
                u.setNama_pembeli(rslt.getString("nama_pembeli"));
                u.setNo_hp(rslt.getString("no_hp"));
               u.setAlamat(rslt.getString("alamat"));
                  u.setKode_motor(rslt.getString("kode_motor"));
                     u.setMerk(rslt.getString("merk"));
                        u.setWarna(rslt.getString("warna"));
                           u.setHarga(rslt.getString("harga"));
                              u.setTanggal(rslt.getString("tanggal"));
                us.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return us;

    }
     
       public User save(User user) {
        java.sql.Connection conn = new DBConnection().connect();
        //Convert Date To String
      //  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      //  String tanggal = sdf.format(mahasiswa.getTgl_masuk());
        try {
            String sql = "insert into user(id_user,username,password) values(?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);

            try {
                stmt.setString(1, user.getId_user());
                stmt.setString(2, user.getUsername());
                stmt.setString(3, user.getPassoword());
               
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
        return user;

    }
       public User update(User user) {
        java.sql.Connection conn = new DBConnection().connect();

        try {
            String sql = "update user set username=?,password=? where id_user=?";
            java.sql.PreparedStatement update = conn.prepareStatement(sql);

            try {
                update.setString(1, user.getUsername());
                update.setString(2, user.getPassoword());
                update.setString(3, user.getId_user());
              
                update.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di ubah");

            } catch (SQLException se) {
                System.out.println("Error = " + se);
                JOptionPane.showMessageDialog(null, "Data Gagal di ubah");
            }
            update.close();
        } catch (Exception e) {
        }
        return user;
    }
       public User getID(User u) {
        java.sql.Connection conn = new DBConnection().connect();
        try {
            String sql = "Select * from user where id_user='"+u.getId_user()+"'";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                u = new User();
                u.setId_user(rslt.getString("id_user"));
                u.setUsername(rslt.getString("username"));
                u.setPassoword(rslt.getString("password"));
             
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return u;

    }
       public User delete(User user) {
        java.sql.Connection conn = new DBConnection().connect();

        try {
            String sql = "delete from user where id_user=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);

            try {
                stmt.setString(1, user.getId_user());

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di hapus");

            } catch (SQLException se) {
                System.out.println("Error = " + se);
                JOptionPane.showMessageDialog(null, "Data Gagal di hapus");
            }
            stmt.close();
        } catch (Exception e) {
        }
        return user;

    }
public List<User> searching(String teks) {
        java.sql.Connection conn = new DBConnection().connect();
        List<User> us = null;
        try {
            us = new ArrayList<>();
            String sql = "Select * from user where id_user like ? OR username like ?";
            java.sql.PreparedStatement cari = conn.prepareStatement(sql);
            cari.setString(1, "%" + teks + "%");
            cari.setString(2, "%" + teks + "%");
            java.sql.ResultSet rslt = cari.executeQuery();
            while (rslt.next()) {
                User u = new User();
                u.setId_user(rslt.getString("id_user"));
                u.setUsername(rslt.getString("username"));
                u.setPassoword(rslt.getString("password"));
              
                us.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return us;
    }


       
       
}

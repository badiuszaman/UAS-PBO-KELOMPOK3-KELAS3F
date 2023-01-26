/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uas.controller;

import com.uas.dao.TransaksiDAO;
import com.uas.model.Transaksi;
import java.util.List;

/**
 *
 * @author HP
 */
public class TransaksiController {
      private TransaksiDAO transaksiDAO = new TransaksiDAO();
     public List<Transaksi> getAll() {
        return transaksiDAO.getAll();
    }
               public Transaksi getKode_transaksi(Transaksi t){
        return transaksiDAO.getKode_transaksi(t);
    }
                     public Transaksi getKode_pembeli(Transaksi p){
        return transaksiDAO.getKode_transaksi(p);
    }
                 public Transaksi getKode_motor(Transaksi m){
        return transaksiDAO.getKode_transaksi(m);
    }          
               public Transaksi save(Transaksi transaksi) {
        return transaksiDAO.save(transaksi);
    }
                public Transaksi update(Transaksi transaksi) {
        return transaksiDAO.update(transaksi);
    }
             
                   public Transaksi delete(Transaksi transaksi) {
        return transaksiDAO.delete(transaksi);
    }
        public List<Transaksi> searching (String teks){
            return transaksiDAO.searching(teks);
        }
        
               
          
               
               
               
               
               
               
               
               
 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uas.controller;

import com.uas.dao.PembeliDAO;
import com.uas.koneksi.DBConnection;
import com.uas.model.Pembeli;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author senja
 */
public class PembeliController {
     private PembeliDAO pembeliDAO = new PembeliDAO();
     public List<Pembeli> getAll() {
        return pembeliDAO.getAll();
    }
           public Pembeli getKode_pembeli(Pembeli p){
        return pembeliDAO.getKode_pembeli(p);
    }
               public Pembeli save(Pembeli pembeli) {
        return pembeliDAO.save(pembeli);
    }
                public Pembeli update(Pembeli pembeli) {
        return pembeliDAO.update(pembeli);
    }
              public Pembeli getID(Pembeli p){
        return pembeliDAO.getID(p);
    }
                   public Pembeli delete(Pembeli pembeli) {
        return pembeliDAO.delete(pembeli);
    }
        public List<Pembeli> searching (String teks){
            return pembeliDAO.searching(teks);
        }
        
               
          
               
               
               
               
               
               
               
               
               
               
               
}

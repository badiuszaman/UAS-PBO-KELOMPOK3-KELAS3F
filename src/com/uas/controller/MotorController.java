/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uas.controller;

import com.uas.dao.MotorDAO;
import com.uas.model.Motor;
import java.util.List;

/**
 *
 * @author senja
 */
public class MotorController {
     private MotorDAO MotorDAO = new MotorDAO();
     public List<Motor> getAll() {
        return MotorDAO.getAll();
    }
           public Motor getKode_motor(Motor m){
        return MotorDAO.getKode_motor(m);
    }
                   public Motor save(Motor motor) {
        return MotorDAO.save(motor);
    }
                public Motor update(Motor motor) {
        return MotorDAO.update(motor);
    }
              public Motor getID(Motor m){
        return MotorDAO.getID(m);
              }
                   public Motor delete(Motor motor) {
        return MotorDAO.delete(motor);
    }
        public List<Motor> searching (String teks){
            return MotorDAO.searching(teks);
        }
}

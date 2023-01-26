/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uas.controller;
import com.uas.dao.UserDAO;
import com.uas.model.User;
import java.util.List;
/**
 *
 * @author senja
 */
public class UserController {
      private UserDAO userDAO = new UserDAO();
     public List<User> getAll() {
        return userDAO.getAll();
    }
        public User save(User user) {
        return userDAO.save(user);
    }
    
    public User update(User user) {
        return userDAO.update(user);
    }
              public User getID(User u){
        return userDAO.getID(u);
    }
           public User delete(User user) {
        return userDAO.delete(user);
    }
        public List<User> searching (String teks){
            return userDAO.searching(teks);
        }
        
        
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daicent.DAO;

import com.daicent.Model.User;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao {

    DBContext db = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    CallableStatement cs = null;
    Connection connection = null;

    public UserDao() {
        db = new DBContext();
    }

    public void addUser(User u) {
        ArrayList<User> list = new ArrayList<>();
        try {
            connection = db.getConnection();
            String sql = "exec insertUser ?,?";
            cs = connection.prepareCall(sql);
            cs.setString(1, u.getUsername());
            cs.setString(2, u.getPassword());
            cs.executeUpdate();
            rs = cs.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                list.add(u);
            }
            for (User user : list) {
                System.out.println(user.toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void InsertUser(User u) {
        String sql = "Insert into [";
        Field[] field = u.getClass().getDeclaredFields();
        sql += u.getClass().getSimpleName() + "] ( ";
        for (int i = 1; i < field.length; i++) {
            sql += field[i].getName();
            if (i != field.length - 1) {
                sql += ", ";
            }
        }
        sql += ") values (?,?)";
        try {
            connection = db.getConnection();
            stm = connection.prepareStatement(sql);
            stm.setString(1, u.getUsername());
            stm.setString(2, u.getPassword());
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        User u = new User("zxcvb", "bvcxz");
        UserDao db = new UserDao();
        db.InsertUser(u);
    }
}

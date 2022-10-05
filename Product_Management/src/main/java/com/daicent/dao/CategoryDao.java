/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daicent.dao;

import com.daicent.Entity.Category;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENNOVO
 */
public class CategoryDao {
    DBContext db = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    Connection connection = null;

    public CategoryDao() {
        db = new DBContext();
    }
    public List<Category> getCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "Select c.CategoryName from Category c";
        try {
            connection = db.getConnection();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setName(rs.getString("Categoryname"));
                list.add(c);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }
}

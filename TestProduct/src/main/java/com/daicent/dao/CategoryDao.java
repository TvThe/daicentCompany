/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daicent.dao;

import com.daicent.Entity.Category;
import com.daicent.Entity.CategoryDetail;
import com.daicent.Entity.Product;
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
        String sql = "Select c.cname from Category c";
        try {
            connection = db.getConnection();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setName(rs.getString("cname"));
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
    public List<CategoryDetail> getCategoryDeatail(String n) {
        List<CategoryDetail> list = new ArrayList<>();
        String sql = "Select cd.cdname from CategoryDetail cd join Category c on cd.categoryid = c.cid where c.cname = ?";
        try {
            connection = db.getConnection();
            stm = connection.prepareStatement(sql);
            stm.setString(1, n);
            rs = stm.executeQuery();
            while (rs.next()) {
                CategoryDetail cd = new CategoryDetail();
                cd.setName(rs.getString("cdname"));
//                Category c = new Category();
//                c.setName(rs.getString("cname"));
//                cd.setCategory(c);
                list.add(cd);
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
    public static void main(String[] args) {
        ProductDao dbProduct = new ProductDao();
        CategoryDao c = new CategoryDao();
        List<Category> cate = c.getCategory();
        for (Category category : cate) {
            System.out.println(category.getName());
            System.out.println("-----------------");
            List<CategoryDetail> list = c.getCategoryDeatail(category.getName());
            for (CategoryDetail categoryDetail : list) {
                System.out.println(categoryDetail);
                System.out.println("-----------------");
                List<Product> product = dbProduct.getByDetailName(categoryDetail.getName());
                for (Product product1 : product) {
                    System.out.println(product1);
                    
                }
                System.out.println("-----------------");
            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daicent.dao;

import com.daicent.Entity.Category;
import com.daicent.Entity.Product;
import com.daicent.Entity.Product_Category;
import com.daicent.Entity.Seller;
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
public class ProductDao {

    DBContext db = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    Connection connection = null;

    public ProductDao() {
        db = new DBContext();
    }

    public Product_Category searchByID(int n) {
        int count = 0;
        Product_Category pc = new Product_Category();
        String sql = "Select p.id, p.productname, p.price, s.Seller, c.CategoryName as Category from Product p \n"
                + "join Seller s on p.sellerID = s.id\n"
                + "join Product_Category pc on p.id = pc.ProductID\n"
                + "join Category c on pc.CategoryID = c.id where p.id =?";
        try {

            connection = db.getConnection();
            stm = connection.prepareStatement(sql);
            stm.setInt(1, n);
            rs = stm.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("productname"));
                p.setPrice(rs.getDouble("price"));
                Seller s = new Seller();
                s.setId(rs.getInt("id"));
                s.setSeller(rs.getString("seller"));
                p.setSellerID(s);
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("Category"));
                pc.setProductid(p);
                pc.setCategoryid(c);
                count++;
            }
            return pc;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public List<Product> searchByName(String n) {
        n = "%" + n + "%";
        List<Product> list = new ArrayList<>();
        String sql = "Select p.id, p.productname, p.price, s.Seller from Product p \n"
                + "join Seller s on p.sellerID = s.id where p.productname like ?";
        try {

            connection = db.getConnection();
            stm = connection.prepareStatement(sql);
            stm.setString(1, n);
            rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("productname"));
                p.setPrice(rs.getDouble("price"));
                Seller s = new Seller();
                s.setId(rs.getInt("id"));
                s.setSeller(rs.getString("seller"));
                p.setSellerID(s);
                list.add(p);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public List<Product_Category> searchByCategory(String n) {
        List<Product_Category> list = new ArrayList<>();
        String sql = "Select p.id, p.productname, p.price, s.Seller, c.CategoryName as Category from Product p \n"
                + "join Seller s on p.sellerID = s.id\n"
                + "join Product_Category pc on p.id = pc.ProductID\n"
                + "join Category c on pc.CategoryID = c.id where c.categoryname = ?";
        try {

            connection = db.getConnection();
            stm = connection.prepareStatement(sql);
            stm.setString(1, n);
            rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("productname"));
                p.setPrice(rs.getDouble("price"));
                Seller s = new Seller();
                s.setId(rs.getInt("id"));
                s.setSeller(rs.getString("seller"));
                p.setSellerID(s);
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("Category"));
                Product_Category pc = new Product_Category();
                pc.setProductid(p);
                pc.setCategoryid(c);
                list.add(pc);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;

    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "Select p.id, p.productname, p.price, s.Seller from Product p \n"
                + "join Seller s on p.sellerID = s.id\n";
        try {

            connection = db.getConnection();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("productname"));
                p.setPrice(rs.getDouble("price"));
                Seller s = new Seller();
                s.setId(rs.getInt("id"));
                s.setSeller(rs.getString("seller"));
                p.setSellerID(s);
                list.add(p);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;

    }

    public static void main(String[] args) {
        ProductDao db = new ProductDao();
        List<Product> list = db.getAllProduct();
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }
}

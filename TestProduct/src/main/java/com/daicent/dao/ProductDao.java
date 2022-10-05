/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daicent.dao;

import com.daicent.Entity.CategoryDetail;
import com.daicent.Entity.Product;
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

    public List<Product> getByDetailName(String n) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT p.pname, p.price, s.sname,cd.cdname from Product p\n"
                + "join Sellers s on p.sellerid = s.sid\n"
                + "join CategoryDetail cd on p.cdid = cd.cdid\n"
                + "where cd.cdname like ?";
        try {
            connection = db.getConnection();
            stm= connection.prepareStatement(sql);
            stm.setString(1, n);
            rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString("pname"));
                p.setPrice(rs.getDouble("price"));
                Seller s = new Seller();
                s.setSeller(rs.getString("sname"));
                p.setSellerID(s);
                CategoryDetail cd = new CategoryDetail();
                cd.setName(rs.getString("cdname"));
                p.setCategoryDetail(cd);
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
        List<Product> list = db.getByDetailName("shoes");
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }
}

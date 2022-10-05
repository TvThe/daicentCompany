/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daicent.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENNOVO
 */
public class DBContext {

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlserver://DESKTOP-A8O56R0\\SQLEXPRESS:1433;databaseName=ProductManagement;encrypt=true;trustServerCertificate=true";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, "tvthe1001", "ab123456789");
    }
}

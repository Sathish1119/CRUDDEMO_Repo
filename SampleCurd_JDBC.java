/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sathish.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class SampleCurd_JDBC implements Intrf_Crud_Commmon {

    String dbURL = "jdbc:mysql://localhost:3306/learning";
    String username = "root";
    String password = "Welcome2";
    Connection conn = null;

    @Override
    public int dbConfiguration() {
        try {

            conn = DriverManager.getConnection(dbURL, username, password);
            

            if (conn != null) {
                System.out.println("Connected");
                return 1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public int insertIntoDB() {

        try {
            String sql = "INSERT INTO Student (ID, Name, RegNo, Mark) VALUES (?, ?, ?, ?)";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, 525);
            statement.setString(2, "yyy");
            statement.setInt(3, 562);
            statement.setInt(4, 85);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Student inserted!");
                
            }       } catch (SQLException ex) {
            Logger.getLogger(SampleCurd_JDBC.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        return 1;
    }

    @Override
    public int updateIntoDB() {
        try {
            String sql = "UPDATE Users SET ID=?, Name=?, RegNo=?, Mark=? WHERE ID=?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, 96);
            statement.setString(2, "yyy");
            statement.setInt(2, 526);
            statement.setInt(3, 75);
            
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }       } catch (SQLException ex) {
            Logger.getLogger(SampleCurd_JDBC.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        return 1;
    }

    @Override
    public int deleteIntoDB() {
        try {
            String sql = "DELETE FROM Users WHERE username=?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "aaa");
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }       } catch (SQLException ex) {
            Logger.getLogger(SampleCurd_JDBC.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        return 1;
    }

    @Override
    public int selectFromDB() {
        try {
            String sql = "SELECT * FROM Users";
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            int count = 0;
            
            while (result.next()){
                String name = result.getString(2);
                String pass = result.getString(3);
                String fullname = result.getString("fullname");
                String email = result.getString("email");
                
                String output = "User #%d: %s - %s - %s - %s";
                System.out.println(String.format(output, ++count, name, pass, fullname, email));
            }       } catch (SQLException ex) {
            Logger.getLogger(SampleCurd_JDBC.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        return 1;
    }

    @Override
    public int closeOperation() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SampleCurd_JDBC.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        return 1;
    }

}

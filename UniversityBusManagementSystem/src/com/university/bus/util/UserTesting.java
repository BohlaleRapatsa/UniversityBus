/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bus.util;


import java.sql.*;

public class UserTesting {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/universitybus";
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("id") + 
                                   " | Username: " + rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bus.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/universitybus"; 
        String user = "root";
        String password = ""; 

        try {
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("SUCCESS! Connection established.");
            conn.close();
        } catch (SQLException e) {
            System.out.println("FAILURE! Check your credentials or database name.");
            e.printStackTrace();
        }
    }
}
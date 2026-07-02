/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bus.dao;

import com.university.bus.model.User;
import java.sql.*;

public class UserDAO {
    
    private final String url = "jdbc:mysql://localhost:3306/universitybus?useSSL=false&allowPublicKeyRetrieval=true";
    private final String user = "root";
    private final String password = ""; // Ensure NO spaces between quotes

    public User loginUser(String username, String password) {
    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
    

    try (Connection conn = DriverManager.getConnection(url, "root", null)) {
        
        System.out.println("DEBUG: Connection successful! Now preparing statement...");
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("DEBUG: User found in database.");
                return new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
                );
            } else {
                System.out.println("DEBUG: No matching user found for: " + username);
            }
        }
        
    } catch (SQLException e) {
        System.err.println("CRITICAL ERROR in loginUser method!");
        e.printStackTrace();
    }
    return null;
}

    public boolean registerUser(User newUser) {
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, newUser.getUsername());
            pstmt.setString(2, newUser.getPassword());
            pstmt.setString(3, newUser.getRole());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
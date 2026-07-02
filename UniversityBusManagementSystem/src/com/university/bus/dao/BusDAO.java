/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bus.dao;

import com.university.bus.model.Bus;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {
    private final String url = "jdbc:mysql://localhost:3306/universitybus?useSSL=false&allowPublicKeyRetrieval=true";
    private final String user = "root";

    public boolean addBus(Bus bus) {
        String sql = "INSERT INTO buses (plate_number, capacity, status) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(url, user, null);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, bus.getPlateNumber());
            pstmt.setInt(2, bus.getCapacity());
            pstmt.setString(3, bus.getStatus());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Bus> getAllBuses() {
        List<Bus> buses = new ArrayList<>();
        String sql = "SELECT * FROM buses";
        
        try (Connection conn = DriverManager.getConnection(url, user, null);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {

                buses.add(new Bus(
                    rs.getInt("bus_id"),
                    rs.getString("plate_number"),
                    rs.getInt("capacity"),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buses;
    }
}
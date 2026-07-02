/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bus.dao;

import com.university.bus.model.Route;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO {
    private final String url = "jdbc:mysql://localhost:3306/universitybus?useSSL=false&allowPublicKeyRetrieval=true";
    private final String user = "root";

    public boolean addRoute(Route route) {
        String sql = "INSERT INTO routes (start_point, end_point, departure_time) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(url, user, null);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, route.getStartPoint());
            pstmt.setString(2, route.getEndPoint());
            pstmt.setString(3, route.getDepartureTime());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Route> getAllRoutes() {
        List<Route> routes = new ArrayList<>();
        String sql = "SELECT * FROM routes";
        
        try (Connection conn = DriverManager.getConnection(url, user, null);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                routes.add(new Route(
                    rs.getInt("route_id"),
                    rs.getString("start_point"),
                    rs.getString("end_point"),
                    rs.getString("departure_time")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routes;
    }
}
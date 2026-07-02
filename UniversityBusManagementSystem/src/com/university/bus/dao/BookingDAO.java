/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bus.dao;

import com.university.bus.model.Booking;
import com.university.bus.model.BookingDetails;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private final String url = "jdbc:mysql://localhost:3306/universitybus?useSSL=false&allowPublicKeyRetrieval=true";
    private final String user = "root";

    public boolean createBooking(Booking booking) {
        String sql = "INSERT INTO bookings (user_id, route_id, booking_date) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(url, user, null);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, booking.getUserId());
            pstmt.setInt(2, booking.getRouteId());
            pstmt.setDate(3, booking.getBookingDate()); 
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Booking> getBookingsByUserId(int userId) {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE user_id = ?";
        
        try (Connection conn = DriverManager.getConnection(url, user, null);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                bookings.add(new Booking(
                    rs.getInt("booking_id"),
                    rs.getInt("user_id"),
                    rs.getInt("route_id"),
                    rs.getDate("booking_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
    
    public List<BookingDetails> getFullBookingDetails(int userId) {
    List<BookingDetails> detailsList = new ArrayList<>();

    String sql = "SELECT b.booking_id, r.start_point, r.end_point, r.departure_time, b.booking_date " +
                 "FROM bookings b " +
                 "JOIN routes r ON b.route_id = r.route_id " +
                 "WHERE b.user_id = ?";

    try (Connection conn = DriverManager.getConnection(url, user, null);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setInt(1, userId);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            detailsList.add(new BookingDetails(
                rs.getInt("booking_id"),
                rs.getString("start_point"),
                rs.getString("end_point"),
                rs.getString("departure_time"),
                rs.getDate("booking_date")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return detailsList;
}
    
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bus.model;

import java.sql.Date; 

public class Booking {
    private int bookingId;
    private int userId;
    private int routeId;
    private Date bookingDate;

    public Booking(int userId, int routeId, Date bookingDate) {
        this.userId = userId;
        this.routeId = routeId;
        this.bookingDate = bookingDate;
    }

    public Booking(int bookingId, int userId, int routeId, Date bookingDate) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.routeId = routeId;
        this.bookingDate = bookingDate;
    }

    public int getBookingId() { 
        return bookingId; 
    }
    
    public int getUserId() { 
        return userId; 
    }
    
    public int getRouteId() { 
        return routeId; 
    }
    
    public Date getBookingDate() { 
        return bookingDate; 
    }
}
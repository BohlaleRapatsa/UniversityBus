/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bus.model;

import java.sql.Date;

public class BookingDetails {
    private int bookingId;
    private String startPoint;
    private String endPoint;
    private String departureTime;
    private Date bookingDate;

    public BookingDetails(int bookingId, String startPoint, String endPoint, String departureTime, Date bookingDate) {
        this.bookingId = bookingId;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.departureTime = departureTime;
        this.bookingDate = bookingDate;
    }



    public String getFullRoute() { 
        return startPoint + " to " + endPoint; 
    }
    
    public String getDepartureTime() { 
        return departureTime; 
    }
    
    public Date getBookingDate() { 
        return bookingDate; 
    }
    
public int getBookingId() { 
    return bookingId; 
}
}

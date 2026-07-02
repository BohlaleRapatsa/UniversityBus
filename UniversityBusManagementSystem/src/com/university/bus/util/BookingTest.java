/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bus.util;

import com.university.bus.dao.BookingDAO;
import com.university.bus.model.Booking;
import com.university.bus.model.BookingDetails;
import java.sql.Date;
import java.util.List;

public class BookingTest {
    public static void main(String[] args) {
        BookingDAO dao = new BookingDAO();

        
        Date today = new Date(System.currentTimeMillis());

        
        Booking testBooking = new Booking(1, 1, today);

        System.out.println("--- Testing Booking Creation ---");
        if (dao.createBooking(testBooking)) {
            System.out.println("SUCCESS: Ticket issued for User 1 on Route 1!");
        } else {
            System.out.println("FAILURE: Database rejected the booking. Check your Foreign Keys.");
        }
        
    System.out.println("\n--- 3. Testing: Detailed Tickets ---");
    List<BookingDetails> myTickets = dao.getFullBookingDetails(1);

    for (BookingDetails ticket : myTickets) {
        System.out.println("Ticket #" + ticket.getBookingId());
        System.out.println("Route: " + ticket.getFullRoute());
        System.out.println("Departure: " + ticket.getDepartureTime());
        System.out.println("Date: " + ticket.getBookingDate());
        System.out.println("-----------------------------------");
    }
        
    }
}
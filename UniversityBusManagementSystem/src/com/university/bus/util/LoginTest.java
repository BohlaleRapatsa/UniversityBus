/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bus.util;

import com.university.bus.dao.UserDAO;
import com.university.bus.model.User;

public class LoginTest {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        
        System.out.println("--- Testing Login Logic ---");


        User loggedInUser = dao.loginUser("Batista", "securepass123");
        
        if (loggedInUser != null) {
            System.out.println("SUCCESS! Welcome back, " + loggedInUser.getUsername());
            System.out.println("Access Level: " + loggedInUser.getRole());
        } else {
            System.out.println("FAILURE! Invalid username or password.");
        }

        System.out.println("\n--- Testing Failed Login ---");
        

        User failedUser = dao.loginUser("Batista", "wrongpassword123");
        
        if (failedUser == null) {
            System.out.println("SUCCESS! The system correctly rejected the wrong password.");
        } else {
            System.out.println("SECURITY RISK! The system allowed a wrong password.");
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bus.util;

import com.university.bus.dao.UserDAO;
import com.university.bus.model.User;

public class RegistrationTest {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        

        User newUser = new User(0, "Batista", "securepass123", "student");
        

        boolean success = dao.registerUser(newUser);
        
        if (success) {
            System.out.println("Registration Successful! Batista is in the database.");
        } else {
            System.out.println("Registration Failed. Check your database or code.");
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bus.util;

import com.university.bus.dao.BusDAO;
import com.university.bus.model.Bus;
import java.util.List;

public class BusModuleTest {
    public static void main(String[] args) {
        BusDAO busDAO = new BusDAO();

        System.out.println("--- 1. Testing: Adding New Buses ---");
        


        Bus bus1 = new Bus("HNY 533 MP", 65, "active");
        Bus bus2 = new Bus("HKL 900 GP", 50, "maintenance");

        if (busDAO.addBus(bus1)) {
            System.out.println("SUCCESS: Added " + bus1.getPlateNumber());
        } else {
            System.out.println("FAILURE: Could not add " + bus1.getPlateNumber());
        }

        if (busDAO.addBus(bus2)) {
            System.out.println("SUCCESS: Added " + bus2.getPlateNumber());
        }

        System.out.println("\n--- 2. Testing: Retrieving Fleet (camelCase Check) ---");
        
        List<Bus> fleet = busDAO.getAllBuses();
        
        if (fleet.isEmpty()) {
            System.out.println("No buses found in the database.");
        } else {
            System.out.println("Total Buses Found: " + fleet.size());
            System.out.println("--------------------------------------------------");
            for (Bus b : fleet) {
                // Testing if camelCase getters correctly pull snake_case DB data
                System.out.printf("ID: %-3d | Plate: %-12s | Capacity: %-3d | Status: %-12s%n", 
                                  b.getBusId(), 
                                  b.getPlateNumber(), 
                                  b.getCapacity(), 
                                  b.getStatus());
            }
            System.out.println("--------------------------------------------------");
        }
    }
}
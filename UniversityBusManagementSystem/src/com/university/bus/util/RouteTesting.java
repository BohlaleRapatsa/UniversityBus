/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bus.util;

import com.university.bus.dao.RouteDAO;
import com.university.bus.model.Route;
import java.util.List;

public class RouteTesting {
    public static void main(String[] args) {
        RouteDAO routeDAO = new RouteDAO();

        System.out.println("1. Testing: Adding New University Routes");

        Route route1 = new Route("Main Campus Gate", "Varsity Village", "07:30:00");
        Route route2 = new Route("Engineering Building", "Town Centre", "13:15:00");
        Route route3 = new Route("Sports Complex", "Main Residence", "18:00:00");

        if (routeDAO.addRoute(route1)) {
            System.out.println("SUCCESS: Route '" + route1.getStartPoint() + "' added!");
        }
        if (routeDAO.addRoute(route2)) {
            System.out.println("SUCCESS: Route '" + route2.getStartPoint() + "' added!");
        }
        if (routeDAO.addRoute(route3)) {
            System.out.println("SUCCESS: Route '" + route3.getStartPoint() + "' added!");
        }

        System.out.println("\n2. Testing: Retrieving All Routes");
        List<Route> allRoutes = routeDAO.getAllRoutes();

        if (allRoutes.isEmpty()) {
            System.out.println("No routes found Check your database connection.");
        } else {
            System.out.println("Total Active Routes: " + allRoutes.size());
            System.out.println("------------------------------------------------------------");
            System.out.printf("%-5s | %-20s | %-20s | %-10s%n", "ID", "FROM", "TO", "DEPARTS");
            System.out.println("------------------------------------------------------------");
            
            for (Route r : allRoutes) {
                System.out.printf("%-5d | %-20s | %-20s | %-10s%n", 
                                  r.getRouteId(), 
                                  r.getStartPoint(), 
                                  r.getEndPoint(), 
                                  r.getDepartureTime());
            }
            System.out.println("------------------------------------------------------------");
        }
    }
}
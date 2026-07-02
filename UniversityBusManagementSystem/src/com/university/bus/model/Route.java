/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bus.model;

public class Route {
    private int routeId;
    private String startPoint;
    private String endPoint;
    private String departureTime; 


    public Route(String startPoint, String endPoint, String departureTime) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.departureTime = departureTime;
    }

    public Route(int routeId, String startPoint, String endPoint, String departureTime) {
        this.routeId = routeId;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.departureTime = departureTime;
    }

    public int getRouteId() { return routeId; }
    public String getStartPoint() { return startPoint; }
    public String getEndPoint() { return endPoint; }
    public String getDepartureTime() { return departureTime; }

    public void setStartPoint(String startPoint) { this.startPoint = startPoint; }
    public void setEndPoint(String endPoint) { this.endPoint = endPoint; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bus.model;

public class Bus {
    private int busId;
    private String plateNumber;
    private int capacity;
    private String status;


    public Bus(String plateNumber, int capacity, String status) {
        this.plateNumber = plateNumber;
        this.capacity = capacity;
        this.status = status;
    }


    public Bus(int busId, String plateNumber, int capacity, String status) {
        this.busId = busId;
        this.plateNumber = plateNumber;
        this.capacity = capacity;
        this.status = status;
    }


    public int getBusId() { 
        return busId; 
    }
    
    public String getPlateNumber() {
        return plateNumber; 
    }
    
    public int getCapacity() { 
        return capacity; 
    }
    
    public String getStatus() { 
        return status; 
    }


    public void setPlateNumber(String plateNumber) { 
        this.plateNumber = plateNumber; 
    }
    
    public void setCapacity(int capacity) { 
        this.capacity = capacity; 
    }
    
    public void setStatus(String status) { 
        this.status = status; 
    }
}
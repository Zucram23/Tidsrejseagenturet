package com.example.tidsagenturet.Extra_Classes;

public class TimeMachine {
    private int id;
    private String name;
    private int capacity;
    private String status;

    public TimeMachine(int id, String name, int capacity, String status) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.status = status;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public String getStatus() { return status; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString(){
        return name;
    }

}


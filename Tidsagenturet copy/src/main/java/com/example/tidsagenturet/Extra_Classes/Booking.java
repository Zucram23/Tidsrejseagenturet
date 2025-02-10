package com.example.tidsagenturet.Extra_Classes;

public class Booking {
    private int id;
    private Customer customer;
    private TimeMachine timeMachine;
    private TimePeriod timePeriod;
    private Guide guide;

    public Booking(int id, Customer customer, TimeMachine timeMachine, TimePeriod timePeriod, Guide guide) {
        this.id = id;
        this.customer = customer;
        this.timeMachine = timeMachine;
        this.timePeriod = timePeriod;
        this.guide = guide;
    }

    public int getId() { return id; }
    public Customer getCustomer() { return customer; }
    public TimeMachine getTimeMachine() { return timeMachine; }
    public TimePeriod getTimePeriod() { return timePeriod; }
    public Guide getGuide() { return guide; }

    public void setId(int id) { this.id = id; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public void setTimeMachine(TimeMachine timeMachine) { this.timeMachine = timeMachine; }
    public void setTimePeriod(TimePeriod timePeriod) { this.timePeriod = timePeriod; }
    public void setGuide(Guide guide) { this.guide = guide; }

    @Override
    public String toString(){
        return "You have booked "+timeMachine.getName()+" With "+guide.getName()+" as your guide for the "+timePeriod.getName();
    }
}

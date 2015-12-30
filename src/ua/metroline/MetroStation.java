package ua.metroline;

import ua.passengers.Passenger;

import java.util.LinkedList;

/**
 * Created by liny on 24.12.15.
 */
public class MetroStation {
    private String name;
    private LinkedList<Passenger> passengers;

    public MetroStation(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name ;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

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
        return "\nMetroStation " +
                "name " + name + '\'' +
                " passengers " + passengers ;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(LinkedList<Passenger> passengers) {
        this.passengers = passengers;
    }
}


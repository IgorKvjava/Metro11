package ua.depo;

import ua.passengers.Passenger;
import java.util.LinkedList;

/**
 * Created by univer3 on 12/12/2015.
 */
public class DepoWagon {
    private String nameWagon;
    private boolean typeWagon;
    private LinkedList<Passenger> passengers;

    public DepoWagon(String nameWagon, boolean mainVagon) {
        this.nameWagon = nameWagon;
        this.typeWagon = mainVagon;
    }

    public DepoWagon() {
    }

    public String getNameWagon() {
        return nameWagon;
    }

    public void setNameWagon(String nameWagon) {
        this.nameWagon = nameWagon;
    }

    public boolean isTypeWagon() {
        return typeWagon;
    }

    public void setTypeWagon(boolean typeWagon) {
        this.typeWagon = typeWagon;
    }

    public LinkedList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(LinkedList<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Wagon < " +
                "name  " + nameWagon +
                "  type  " + typeWagon +
                " passengers"+passengers+" >\n";
    }
}

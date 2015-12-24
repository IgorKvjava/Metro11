package ua.metroline;

/**
 * Created by liny on 24.12.15.
 */
public class MetroStation {
    private String name;

    public MetroStation(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " Station " + name ;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

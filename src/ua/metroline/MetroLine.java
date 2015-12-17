package ua.metroline;

import ua.depo.Train;

import java.util.LinkedList;

/**
 * Created by liny on 17.12.15.
 */
public class MetroLine {
    private String name;
    private LinkedList<TrainOnLine> trainsOnLine;

    public MetroLine(String name, LinkedList<TrainOnLine> trainsOnLine) {
        this.name = name;
        this.trainsOnLine = trainsOnLine;
    }

    @Override
    public String toString() {
        return "MetroLine{" +
                "name='" + name + '\'' +
                ", trainsOnLine=" + trainsOnLine +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<TrainOnLine> getTrainsOnLine() {
        return trainsOnLine;
    }

    public void setTrainsOnLine(LinkedList<TrainOnLine> trainsOnLine) {
        this.trainsOnLine = trainsOnLine;
    }
}

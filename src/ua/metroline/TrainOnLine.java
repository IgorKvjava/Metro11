package ua.metroline;

import ua.depo.Train;
import ua.driver.MetroDriver;

/**
 * Created by liny on 17.12.15.
 */
public class TrainOnLine {
    private MetroDriver metroDriver;
    private Train train;

    public TrainOnLine(MetroDriver metroDriver, Train train) {
        this.metroDriver = metroDriver;
        this.train = train;
    }

    @Override
    public String toString() {
        return " Train staffed --- \n" +
                "metroDriver=" + metroDriver +
                " train=" + train +"\n";
    }

    public MetroDriver getMetroDriver() {
        return metroDriver;
    }

    public void setMetroDriver(MetroDriver metroDriver) {
        this.metroDriver = metroDriver;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}

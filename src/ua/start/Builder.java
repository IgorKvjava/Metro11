package ua.start;

import ua.depo.DepoWagon;
import ua.depo.Train;
import ua.driver.MetroDriver;
import ua.metroline.MetroLine;
import ua.metroline.MetroStation;

import java.util.*;

/**
 * Created by liny on 24.12.15.
 */
public class Builder {
    // List
    LinkedList<DepoWagon> wagons = new LinkedList<>();
    LinkedList<Train> trains = new LinkedList<>();
    PriorityQueue<MetroDriver> metroDriverPriorityQueue;
    LinkedList<MetroLine> metroLines=new LinkedList<>();

    String [] nameStations={"Red","Green","Blue"};
    //Consist Trains-------------------------------------------------------------
    public void builderTrains() {
        //Consist wagons-------------------------------------------------------------
        String name = "wagon-";
        int count = 0;
        boolean mainWagon=true;
        for (int i=0;i<104;i++ ){
            wagons.add(new DepoWagon(name+i,mainWagon));
            if((Math.random()*100)>50)
            {mainWagon=false;}
            else  mainWagon=true;
            }
        System.out.println("wagons size "+wagons.size());
        //Consist Trains-------------------------------------------------------------
        String nameTrain = "train";
        int b;
        int sizeDepo = wagons.size() / 5;
        DepoWagon depoWagon;
        for (int i = 0; i < sizeDepo; i++) {
            Train train1 = new Train(nameTrain + "-" + i);
            //System.out.println("Train name= " + train1.getName());
            boolean a = true;
            Iterator<DepoWagon> depoWagonIterator=wagons.iterator();
            while (depoWagonIterator.hasNext() && a) {
                b = train1.trainSetting(depoWagonIterator.next());
                if (b == 1) {depoWagonIterator.remove();}
                if (train1.getCarriages().size() == 5) {a = false;}
            }
            trains.add(train1);
        }
    }
    //Consist metro driver-------------------------------------------------
    public void builderMetroDrivers (){
        //comparison of skills Driver
        Comparator<MetroDriver> metroDriverComparator=new Comparator<MetroDriver>() {
            @Override
            public int compare(MetroDriver o1, MetroDriver o2) {
               return -Double.compare(o1.getSkill(),o2.getSkill());
            }
        };
        // Metro Drivers
        PriorityQueue<MetroDriver> metroDriverPriorityQueue=new PriorityQueue<>(metroDriverComparator);
        String nameDriver="Driver";
        Random rand = new Random();
        for (int i = 0; i <20 ; i++) {
            metroDriverPriorityQueue.add(new MetroDriver(rand.nextInt(45),nameDriver+"-"+i));
        }
        this.metroDriverPriorityQueue=metroDriverPriorityQueue;
    }
    //Drivers distribute on trains and distribute metro lines -------------------------------------------------
    public void builderMetroLine(int countTrainsLine, LinkedList<Train> trains,PriorityQueue<MetroDriver> metroDriverPriorityQueue){
        Iterator<Train> trainIterator=trains.iterator();
        for (int i = 0; i < 3; i++) {
            int countStations=0;
            // metro Stations ----------------
            LinkedList<MetroStation> metroStations=new LinkedList<>();
            for (int j = 0; j <10 ; j++) {
                metroStations.add(j,new MetroStation(nameStations[i]+" - "+j));
            }
            //  trains  Line ---------------
            LinkedList<Train> trainsLine=new LinkedList<>();
            while (trainIterator.hasNext()){
                MetroDriver metroDriver=metroDriverPriorityQueue.poll();
                Train trainLine ;//=new Train(null,null,null);
                trainLine=trainIterator.next();
                trainLine.setMetroDriver(metroDriver);
                trainsLine.add(trainLine);
                countStations++;
                if (countStations>countTrainsLine) break;
                }
                metroLines.add(new MetroLine(nameStations[i],trainsLine,metroStations));

        }
    }

}

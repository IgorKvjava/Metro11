package ua.start;

import ua.depo.DepoWagon;
import ua.depo.Train;
import ua.driver.MetroDriver;
import ua.metroline.MetroLine;
import ua.metroline.MetroStation;
import ua.passengers.Passenger;

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
    Random rand = new Random();

    String [] nameStations={"Red","Green","Blue"};
    //Completion Trains-------------------------------------------------------------------------------------------
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
    //CCompletion metro driver-------------------------------------------------------------------------------------
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
        for (int i = 0; i <20 ; i++) {
            metroDriverPriorityQueue.add(new MetroDriver(rand.nextInt(45),nameDriver+"-"+i));
        }
        this.metroDriverPriorityQueue=metroDriverPriorityQueue;
    }
    //Drivers distribute on trains and distribute metro lines -------------------------------------------------
    public void builderMetroLine(int countTrainsLine, LinkedList<Train> trains,PriorityQueue<MetroDriver> metroDriverPriorityQueue){
        LinkedList<MetroLine> metroLines=new LinkedList<>();
        Iterator<Train> trainIterator=trains.iterator();
        int countMetroDrivers=metroDriverPriorityQueue.size();
        Train trainLine;
        for (int i = 0; i < 3; i++) {
            int countStations=0;
            // metro Stations ----------------
            LinkedList<MetroStation> metroStations=new LinkedList<>();
            for (int j = 0; j <10 ; j++) {
                metroStations.add(j,new MetroStation(nameStations[i]+"-"+j));
            }
            //  trains  Line ---------------
            LinkedList<Train> trainsLine=new LinkedList<>();
            while (trainIterator.hasNext()){
                MetroDriver metroDriver=metroDriverPriorityQueue.poll();
                trainLine=trainIterator.next();
                trainLine.setMetroDriver(metroDriver);
                trainsLine.add(trainLine);
                metroDriver.Experience();
                //metroDrivers.add(metroDriver);
                countStations++;
                if (countStations>countTrainsLine) break;
                }
                metroLines.add(new MetroLine(nameStations[i],trainsLine,metroStations));

        }
        //DriverPriorityQueue fill
        for (int i = 0; i <countMetroDrivers ; i++) {
            metroDriverPriorityQueue.add(trains.get(i).getMetroDriver());

        }
        this.metroLines=metroLines;

        //System.out.println(metroDriverPriorityQueue);
    }

    //passengers go to wagons
    public void passengerOnStation(){
        metroLines.get(0).getTrainsOnLine().get(0).getCarriages().get(0);

    }
    //make passengers ------------------------------------------------------------
    public void passengersFillOnStation() {
        String namePassenger="Passenger";
        for (int i = 0; i < metroLines.size(); i++) {
            System.out.println("-------------"+metroLines.get(i).getName()+"-------------");
            //namePassenger=namePassenger+" lin "+i;
            //
            for (int j = 0; j < metroLines.get(i).getMetroStations().size() ; j++) {
               // namePassenger=namePassenger+" sta "+j;
                int passengersAmount=rand.nextInt(150)+1;
                LinkedList<Passenger> passengersList = new LinkedList<>();
                //System.out.println(passengersAmount+" -passengers");
                for (int k = 0; k < passengersAmount ; k++) {
                    Passenger passenger=new Passenger(namePassenger+" lin "+i+" sta "+j+" num "+k);
                    passengersList.add(passenger);
                }
                System.out.println(passengersList.size());
                metroLines.get(i).getMetroStations().get(j).setPassengers(passengersList);

            }

        }

    }
}

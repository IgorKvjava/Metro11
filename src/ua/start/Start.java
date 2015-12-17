package ua.start;

import ua.depo.DepoWagon;
import ua.depo.Train;
import ua.driver.MetroDriver;
import ua.metroline.TrainOnLine;

import java.util.*;

/**
 * Created by univer3 on 12/12/2015.
 */
public class Start {
    public static void main(String[] args) {
        //Consist  carriages------------------------------------------
        List<DepoWagon> depoWagons =new ArrayList<>();
        String name="vagon-";
        int count=0;
        for (int i=1;i<21;i++ ){
            depoWagons.add(new DepoWagon(name+(count),true));
            depoWagons.add(new DepoWagon(name+(++count),false));
            depoWagons.add(new DepoWagon(name+(++count),false));
            depoWagons.add(new DepoWagon(name+(++count),false));
            depoWagons.add(new DepoWagon(name+(++count),true));
            count++;
            }
        //System.out.println(depoWagons);
        //Consist Trains-------------------------------------------------------------
        LinkedList<Train> depoTrains=new LinkedList<>();
        String nameTrain="train";
        Iterator<DepoWagon> iterator= depoWagons.iterator();
        int b;
        int sizeDepo= depoWagons.size()/5;
        for (int i = 0; i <sizeDepo ; i++) {
            Train train1=new Train(nameTrain+"-"+i);
            System.out.println("Train name= "+train1.getName());
            boolean a=true;
            while (iterator.hasNext()&& a){
                b=train1.trainSetting(iterator.next());
                //System.out.println("b= "+b);
                if (b==1) iterator.remove();
                if(train1.getCarriages().size()==5){ a=false;}
                //System.out.println("train size - "+train1.getCarriages().size());
            }
            depoTrains.add(train1);
        }

         System.out.println("depoVagons size = "+ depoWagons.size());
        System.out.println("----------      Trains     -------"+depoTrains);
        //Consist metro driver--------------------------------------------------
        List<MetroDriver> metroDrivers= new LinkedList<>();
        String nameDriver="Driver";
        Random rand = new Random();
        for (int i = 0; i <20 ; i++) {
            MetroDriver metroDriver=new MetroDriver(rand.nextInt(45),nameDriver+"-"+i);
            metroDrivers.add(metroDriver);

        }
        //System.out.println("----------Drivers Trains-------\n"+metroDrivers);
        //Sort metro driver
        Collections.sort(metroDrivers);
        System.out.println("----------    Drivers Trains sorting   -------\n"+metroDrivers);

        //Complect On Line Train and drivers-------------------------------------------------
        LinkedList<TrainOnLine> trainOnLines=new LinkedList<>();
        Iterator<MetroDriver> metroDriverIterator= metroDrivers.iterator();
        int indexdepoTrains=0;
        while (metroDriverIterator.hasNext()){
            trainOnLines.add(new TrainOnLine(metroDriverIterator.next(),depoTrains.get(indexdepoTrains)));
            indexdepoTrains++;
        }
        System.out.println("---------------   Train On Lines   --------------------\n"+trainOnLines);






    }
}

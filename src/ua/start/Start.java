package ua.start;

import ua.depo.DepoVagon;
import ua.depo.Train;
import ua.driver.MetroDriver;
import ua.metroline.TrainOnLine;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by univer3 on 12/12/2015.
 */
public class Start {
    public static void main(String[] args) {
        //Consist  carriages------------------------------------------
        List<DepoVagon> depoVagons=new ArrayList<>();
        String name="vagon-";
        int count=0;
        for (int i=1;i<21;i++ ){
            depoVagons.add(new DepoVagon(name+(count),true));
            depoVagons.add(new DepoVagon(name+(++count),false));
            depoVagons.add(new DepoVagon(name+(++count),false));
            depoVagons.add(new DepoVagon(name+(++count),false));
            depoVagons.add(new DepoVagon(name+(++count),true));
            count++;
            }
        //System.out.println(depoVagons);
        //Consist Trains-------------------------------------------------------------
        LinkedList<Train> depoTrains=new LinkedList<>();
        String nameTrain="train";
        Iterator<DepoVagon> iterator=depoVagons.iterator();
        int b;
        int sizeDepo=depoVagons.size()/5;
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

         System.out.println("depoVagons size = "+depoVagons.size());
        System.out.println("----------Trains-------"+depoTrains);
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
        System.out.println("----------Drivers Trains sorting-------\n"+metroDrivers);

        //Complect Train On Line drivers-------------------------------------------------
        LinkedList<TrainOnLine> trainOnLines=new LinkedList<>();
        Iterator<MetroDriver> metroDriverIterator= metroDrivers.iterator();
        int indexdepoTrains=0;
        while (metroDriverIterator.hasNext()){
            trainOnLines.add(new TrainOnLine(metroDriverIterator.next(),depoTrains.get(indexdepoTrains)));
            indexdepoTrains++;
        }
        System.out.println("---------train OnL ines-------\n"+trainOnLines);






    }
}

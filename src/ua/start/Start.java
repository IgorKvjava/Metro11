package ua.start;

import ua.depo.DepoVagon;
import ua.depo.Train;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by univer3 on 12/12/2015.
 */
public class Start {
    public static void main(String[] args) {
        List<DepoVagon> depoVagons=new ArrayList<>();
        String name="vagon-";
        boolean mainVagon=true;
        for (int i=1;i<101;i++ ){
            depoVagons.add(new DepoVagon(name+i,mainVagon));
            if((Math.random()*100)>40)
            {mainVagon=false;}
            else  mainVagon=true;
            }
        System.out.println(depoVagons);
        List<Train> depoTrains=new LinkedList<>();
        String nameTrain="train";
        Iterator<DepoVagon> iterator=depoVagons.iterator();
        for (int i = 0; i <depoVagons.size()/5 ; i++) {
            Train train1=new Train(nameTrain+"-"+i);
            System.out.println("Train name= "+train1.getName());
            boolean a=true;
            while (iterator.hasNext()&& a){
                train1.trainSetting(iterator.next());

                if(train1.getCarriages().size()==5){ a=false;}
                //System.out.println("train size - "+train1.getCarriages().size());
            }
            depoTrains.add(train1);

        }
        System.out.println("Train \n"+depoTrains);
    }
}

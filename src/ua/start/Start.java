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
        int count=0;
        for (int i=1;i<21;i++ ){
            depoVagons.add(new DepoVagon(name+(count),true));
            depoVagons.add(new DepoVagon(name+(++count),false));
            depoVagons.add(new DepoVagon(name+(++count),false));
            depoVagons.add(new DepoVagon(name+(++count),false));
            depoVagons.add(new DepoVagon(name+(++count),true));
            count++;
            }
        System.out.println(depoVagons);
        //
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
        System.out.println("Train size - "+depoTrains.size()+" "+depoTrains.get(depoTrains.size()-1));
    }
}

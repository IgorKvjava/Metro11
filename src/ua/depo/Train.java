package ua.depo;

import ua.driver.MetroDriver;
import java.util.LinkedList;

/**
 * Created by univer3 on 12/12/2015.
 */
public class Train {
    private String name;
    private LinkedList<DepoWagon> carriages;
    private MetroDriver metroDriver;

    public Train() {
    }

    public Train(String name, LinkedList<DepoWagon> carriages, MetroDriver metroDriver) {
        this.name = name;
        this.carriages = carriages;
        this.metroDriver = metroDriver;
    }

    public Train(String name) {
        this.name = name;
        this.carriages = new LinkedList<>();
    }

    public int trainSetting(DepoWagon carriage) {
        int a=0;
        //System.out.println("first vagon= " + carriages.getFirst()+" end vagon = "+carriages.getLast()+" size= " + carriages.size());
        if (carriage.isTypeWagon()) {
            if (fistVagon() & carriages.size() == 4 ) {carriages.addLast(carriage);a=1;}
            if (!fistVagon()) {carriages.addFirst(carriage);a=1;}
            //System.out.println("-----------end vagon= " + carriages.size());}
            else if (fistVagon() & carriages.size() < 4 & carriages.size()>0 ) {carriages.add(carriage);a=1;}
        }
        else if ( carriages.size() < 3 ) {carriages.add(carriage);a=1;} else if (fistVagon() & carriages.size() < 4) {carriages.add(carriage);a=1;}
        //System.out.println(" vagon ----- "+endVagon());
        //System.out.println(" end vagon ----- "+endVagon());
        /*if (endVagon()) {
            System.out.println("----------------Train consist= " + carriages.size()+"  name - "+carriage.getNameWagon()+" main - "+carriage.isTypeWagon());
        }*/
        return a;
    }
    //------------------------------------------------------------
    @Override
    public String toString() {
        return  "\nname - " + name +"\ndriver "+metroDriver +"\n"+
                "carriages\n" + carriages;
    }

    public MetroDriver getMetroDriver() {
        return metroDriver;
    }

    public void setMetroDriver(MetroDriver metroDriver) {
        this.metroDriver = metroDriver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<DepoWagon> getCarriages() {
        return carriages;
    }

    public void setCarriages(LinkedList<DepoWagon> carriages) {
        this.carriages = carriages;
    }

    private boolean fistVagon() {
        if (carriages.size() == 0)
            return false;
        return carriages.getFirst().isTypeWagon();
    }

    private boolean endVagon() {
        if (carriages.size() <5)
            return false;
        return carriages.getLast().isTypeWagon();
    }
}

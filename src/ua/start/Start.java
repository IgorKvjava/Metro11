package ua.start;

/**
 * Created by univer3 on 12/12/2015.
 */
public class Start {
    public static void main(String[] args) {
        Builder builder=new Builder();
        //Completion Trains-------------------------------------------------------------
        builder.builderTrains();
        System.out.println("depo "+builder.trains.size()+" trains");
        //Completion metro driver-------------------------------------------------
        builder.builderMetroDrivers();
        System.out.println(" Drivers count-"+builder.metroDriverPriorityQueue.size());
        //Completion Metro Line
        System.out.println("metroDriverPriorityQueue "+builder.metroDriverPriorityQueue);
        builder.builderMetroLine(7,builder.trains,builder.metroDriverPriorityQueue);
        System.out.println(" Metro Line-"+builder.metroLines);
        System.out.println("metroDriverPriorityQueue "+builder.metroDriverPriorityQueue);








        //Consist  carriages------------------------------------------

         /*System.out.println("depoVagons size = "+ depoWagons.size());
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

*/




    }
}

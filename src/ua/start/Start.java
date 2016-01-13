package ua.start;

import org.xmlpull.v1.XmlPullParserException;
import ua.Xmlcreater;

import java.io.IOException;

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
        System.out.println("metroDriver PriorityQueue "+builder.metroDriverPriorityQueue);
        builder.builderMetroLine(7,builder.trains,builder.metroDriverPriorityQueue);
        System.out.println(" Metro Line-"+builder.metroLines);
        System.out.println("metroDriver PriorityQueue "+builder.metroDriverPriorityQueue+"\n" +
                "----------------------------------------------------------------------------------");
        System.out.println("metroDriver PriorityQueue "+builder.metroDriverPriorityQueue);

        //make xml---------------------------------------------------------------------------------------
        /*Xmlcreater xmlcreater=new Xmlcreater();
        System.out.println(builder.trains.getFirst());
        try {
            xmlcreater.createXMLDOMfile(builder.trains.getFirst());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }*/

        //passengers go to Stations--------------------------------------------------------------------------
        builder.passengersFillOnStation();
        System.out.println(builder.metroLines);
        builder.passengerMoving();

    }
}

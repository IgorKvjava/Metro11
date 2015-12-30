package ua;

import oracle.xml.parser.v2.DOMParser;
import oracle.xml.parser.v2.XMLParser;
import org.w3c.dom.Document;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import ua.depo.DepoWagon;
import ua.depo.Train;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by univer3 on 12/26/2015.
 */
public class Xmlcreater {
    static XMLParser xmlParser;
    static XmlSerializer xmlSerializer;
    static XmlPullParserFactory xmlPullParserFactory;
    static DOMParser domParser;
    static Document document;
    private static void startTag(String tag) throws IllegalArgumentException,
            IllegalStateException, IOException {
        xmlSerializer.startTag(NAMESPACE, tag);
        xmlSerializer.text("\n");
    }
    private static void startTag(String tag, HashMap<String, String> attributes)
            throws IllegalArgumentException, IllegalStateException, IOException {
        xmlSerializer.startTag(NAMESPACE, tag);
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            xmlSerializer.attribute("", entry.getKey(), entry.getValue());
        }
        xmlSerializer.text("\n");
    }
    private static void endTag(String tag) throws IllegalArgumentException,
            IllegalStateException, IOException {
        xmlSerializer.endTag(NAMESPACE, tag);
        xmlSerializer.text("\n");
    }
    private static void writeLine(String tag, String line) throws IOException {
        xmlSerializer.startTag(NAMESPACE, tag);
        xmlSerializer.text(line);
        xmlSerializer.endTag(NAMESPACE, tag);
        xmlSerializer.text("\n");
    }
    final static String NAMESPACE = "http://www.kts.zu/Tariffs";
    public  void createXMLDOMfile(Train train) throws IOException, XmlPullParserException {
        try {
            xmlPullParserFactory=XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        xmlPullParserFactory.setNamespaceAware(true);
        xmlSerializer=xmlPullParserFactory.newSerializer();
        xmlSerializer.setOutput(new PrintWriter("train.xml", "UTF-8"));
        xmlSerializer.setPrefix("tns",NAMESPACE);
        xmlSerializer.startDocument("UTF-8", true);
        xmlSerializer.text("\n");
        startTag("train");
        writeLine("name",train.getName() );
        //
        startTag("carriages");
        Iterator<DepoWagon>  depoWagonIterator=train.getCarriages().iterator();
        while (depoWagonIterator.hasNext()) {
            DepoWagon depoWagon=depoWagonIterator.next();
            startTag("depoWagon");
            writeLine("name", depoWagon.getNameWagon());
            writeLine("type", String.valueOf(depoWagon.isTypeWagon()));
            endTag("depoWagon");
        }
        endTag("carriages");
        //
        startTag("metroDriver");
        writeLine("skill", String.valueOf(train.getMetroDriver().getSkill()));
        writeLine("name",train.getMetroDriver().getName());
        endTag("metroDriver");
        endTag("train");
        xmlSerializer.endDocument();
    }

}

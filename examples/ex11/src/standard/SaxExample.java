package standard;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.jar.Attributes;

/**
 * Created by denis.selutin on 6/22/2015.
 */
public class SaxExample {
    public static void main(String args[]) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new CustomDefaultHandler();
            saxParser.parse("examples\\ex11\\src\\standard\\standard.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class CustomDefaultHandler extends DefaultHandler {

        boolean bfname = false;
        boolean blname = false;
        boolean bnname = false;
        boolean bsalary = false;

        public void startElement (String uri, String localName,
                                  String qName, org.xml.sax.Attributes attributes) throws SAXException {
            System.out.println("Start Element :" + qName);
            if(attributes.getLength() > 0) {
                System.out.println("Id is " + attributes.getValue("id"));
                System.out.println("isUsual salary " + attributes.getValue("isUsual"));
            }
            switch (qName.toUpperCase()) {
                case "CUSTOM:FIRSTNAME":
                    bfname = true;
                    break;
                case "CUSTOM:LASTNAME":
                    blname = true;
                    break;
                case "CUSTOM:NICKNAME":
                    bnname = true;
                    break;
                case "CUSTOM:SALARY":
                    bsalary = true;
                    break;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element :" + qName);

            if("CUSTOM:STAFF".equalsIgnoreCase(qName))
                System.out.println();
        }

        public void characters(char ch[], int start, int length) throws SAXException {
            if (bfname) {
                System.out.println("First Name : " + new String(ch, start, length));
                bfname = false;
            }
            if (blname) {
                System.out.println("Last Name : " + new String(ch, start, length));
                blname = false;
            }
            if (bnname) {
                System.out.println("Nick Name : " + new String(ch, start, length));
                bnname = false;
            }
            if (bsalary) {
                System.out.println("Salary : " + new String(ch, start, length));
                bsalary = false;
            }
        }
    }
}

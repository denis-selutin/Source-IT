package standard;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by denis.selutin on 6/22/2015.
 */
public class DomExample {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("examples\\ex11\\src\\standard\\standard.xml");
        prettyPrint(document);
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        printAttributesInfo(document.getDocumentElement());

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                String id = node.getAttributes().getNamedItem("id").getNodeValue();
                System.out.println("Staff id = " + id);
                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);
                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild().getTextContent().trim();
                        switch (cNode.getNodeName().toUpperCase()) {
                            case "CUSTOM:FIRSTNAME":
                                System.out.println("FIRSTNAME " + content);
                                break;
                            case "CUSTOM:LASTNAME":
                                System.out.println("LASTNAME " + content);
                                break;
                            case "CUSTOM:NICKNAME":
                                System.out.println("NICKNAME " + content);
                                break;
                            case "CUSTOM:SALARY":
                                System.out.println("SALARY " + content);
                                break;
                        }
                    }
                }
                System.out.println();
            }
        }
        Node staff = document.createElement("custom:staff");
        ((Element)staff).setAttribute("id", "2656");
        Node salary = document.createElement("custom:salary");
        salary.setTextContent("846544");
        staff.appendChild(salary);
        document.getDocumentElement().appendChild(staff);
        prettyPrint(document);
    }
    public static void printAttributesInfo(Node root) {
        NamedNodeMap attributes = root.getAttributes();
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                Node node = attributes.item(i);
                if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
                    String name = node.getNodeName();
                    System.out.println(name + " " + node.getNamespaceURI());
                }
            }
        }
    }

    public static final void prettyPrint(Document xml) throws Exception {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        Writer out = new StringWriter();
        tf.transform(new DOMSource(xml), new StreamResult(out));
        System.out.println(out.toString());
    }
}

package xmlbinding.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import xmlbinding.ObjectBinder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public class MyClassDomBinder implements ObjectBinder<MyClass> {
    DocumentBuilder builder;
    DocumentBuilderFactory factory;
    public MyClassDomBinder() throws ParserConfigurationException {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
    }

    @Override
    public MyClass create() {
        return new MyClass();
    }

    @Override
    public Collection<MyClass> deserialize(String filename) throws IOException, SAXException {
        List<MyClass> result = new ArrayList<>();
        Document document = builder.parse(filename);
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        //обрабатываем наши данные
        return result;
    }

    @Override
    public void serialize(MyClass object, String filename) throws TransformerException {
        // root elements
        Document doc = builder.newDocument();
        Element rootElement = doc.createElement("myElement");
        //заполняем doc нашими данными
        //записываем в файл
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filename));
        transformer.transform(source, result);
    }

    @Override
    public void serialize(List<MyClass> objects, String filename) {
        //выполняется по аналогии с  serialize для одного обьекта
    }
}

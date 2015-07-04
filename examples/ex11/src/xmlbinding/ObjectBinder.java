package xmlbinding;

import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public interface ObjectBinder<T> {
    T create();
    Collection<T> deserialize(String filename) throws IOException, SAXException;
    void serialize(T object, String filename) throws TransformerException;
    void serialize(List<T> objects, String filename);
}

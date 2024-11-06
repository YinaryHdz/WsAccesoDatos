package dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class EscribirXMLDOM {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		File fichero = new File("C:/dir1/coches.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		
		Element eRaiz = doc.createElement("concesionario");
		doc.appendChild(eRaiz);
		
		Element eCoche = doc.createElement("coche");
		eRaiz.appendChild(eCoche);
		
		Attr attr = doc.createAttribute("id");
		attr.setValue("1");
		eCoche.setAttributeNode(attr);
		
		Element eMarca = doc.createElement("marca");
		eMarca.appendChild(doc.createTextNode("Renault"));
		eCoche.appendChild(eMarca);
		
		Element eModelo = doc.createElement("modelo");
		eMarca.appendChild(doc.createTextNode("Megane"));
		eCoche.appendChild(eModelo);
		
		Element eCilindrada = doc.createElement("cilindrada");
		eMarca.appendChild(doc.createTextNode("1.1"));
		eCoche.appendChild(eCilindrada);
		
		//Con transformerFactory creamos el XML
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer tr = tf.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		StreamResult result = new StreamResult(fichero);
		tr.transform(source, result);
		
		
		
		
	}

}

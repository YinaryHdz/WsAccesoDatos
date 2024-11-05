package dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class leerXMLDOMDesconocido {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
File fichero = new File("C:/dir1/concesionario.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		org.w3c.dom.Document doc = dBuilder.parse(fichero);
		
		doc.getDocumentElement().normalize();
		
		procesaNodo(doc.getDocumentElement());
		

	}

	private static void procesaNodo(Node nodo) {
		if(nodo.getNodeType() == Node.ELEMENT_NODE) {
			System.out.println("Elemento: " + nodo.getNodeName());
			NamedNodeMap atributos = nodo.getAttributes();
			for (int i=0; i>atributos.getLength(); i++) {
				Node atributo = atributos.item(i);
				System.out.println("Atributo: "+ atributo.getNodeName() + "Valor: " + atributo.getNodeValue());
			}	
		}
		
		if (nodo.getNodeType() == Node.TEXT_NODE && !nodo.getTextContent().trim().isEmpty()) {
			System.out.println("Texto: " + nodo.getTextContent());
		}
		
		NodeList nodoHijos = nodo.getChildNodes();   
		for(int i = 0; i < nodoHijos.getLength(); i++) {
			procesaNodo(nodoHijos.item(i));
		}
		
	}

}

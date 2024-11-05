package dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class leerXMLDOM {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File fichero = new File("C:/dir1/concesionario.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		org.w3c.dom.Document doc = dBuilder.parse(fichero);
		
		doc.getDocumentElement().normalize();
		
		NodeList nList = doc.getElementsByTagName("coche");
		System.out.println("Nº coches: " + nList.getLength());
		
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			Element eElement = (Element) nNode;
			System.out.println("Choche id: " + eElement.getAttribute("id"));
			System.out.println("\tMarca: " + eElement.getElementsByTagName("marca").item(0).getTextContent());
			System.out.println("\tModelo: " + eElement.getElementsByTagName("modelo").item(0).getTextContent());
			System.out.println("\tCilindrada: " + eElement.getElementsByTagName("cilindrada").item(0).getTextContent());
		}

	}

}

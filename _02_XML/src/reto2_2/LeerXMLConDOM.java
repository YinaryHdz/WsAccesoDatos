package reto2_2;

import org.w3c.dom.*;
import javax.xml.parsers.*;

public class LeerXMLConDOM {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Leer el archivo XML
            Document doc = builder.parse("Personas.xml");

            // Obtener el nodo raíz
            Element root = doc.getDocumentElement();
            NodeList personas = root.getElementsByTagName("Persona");

            // Iterar por cada persona
            for (int i = 0; i < personas.getLength(); i++) {
                Node personaNode = personas.item(i);

                if (personaNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element personaElement = (Element) personaNode;

                    String nombre = personaElement.getElementsByTagName("Nombre").item(0).getTextContent();
                    String edad = personaElement.getElementsByTagName("Edad").item(0).getTextContent();
                    String telefono = personaElement.getElementsByTagName("Telefono").item(0).getTextContent();

                    System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Teléfono: " + telefono);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

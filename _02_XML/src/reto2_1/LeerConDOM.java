package reto2_1;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class LeerConDOM {
    public static void main(String[] args) {
        try {
            // Crear una instancia de DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Cargar el archivo XML
            Document doc = builder.parse(new File("almacen.xml"));

            // Obtener el nodo raíz
            Element root = doc.getDocumentElement();
            printNode(root, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para imprimir nodos y valores
    private static void printNode(Node node, int level) {
        String indent = "  ".repeat(level);

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(indent + "<" + node.getNodeName() + ">");

            // Imprimir atributos del nodo
            NamedNodeMap attributes = node.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                Node attr = attributes.item(i);
                System.out.println(indent + "  [Atributo] " + attr.getNodeName() + ": " + attr.getNodeValue());
            }

            // Recorrer los hijos
            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                printNode(children.item(i), level + 1);
            }

            System.out.println(indent + "</" + node.getNodeName() + ">");
        } else if (node.getNodeType() == Node.TEXT_NODE && !node.getTextContent().trim().isEmpty()) {
            System.out.println(indent + node.getTextContent().trim());
        }
    }
}

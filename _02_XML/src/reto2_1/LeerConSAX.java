package reto2_1;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class LeerConSAX {
    public static void main(String[] args) {
        try {
            // Crear una instancia de SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            // Configurar el manejador
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    System.out.print("<" + qName + ">");
                    for (int i = 0; i < attributes.getLength(); i++) {
                        System.out.print(" [Atributo] " + attributes.getQName(i) + ": " + attributes.getValue(i));
                    }
                    System.out.println();
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    String content = new String(ch, start, length).trim();
                    if (!content.isEmpty()) {
                        System.out.println(content);
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) {
                    System.out.println("</" + qName + ">");
                }
            };

            // Leer el archivo XML
            parser.parse(new File("almacen.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package reto2_2;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class LeerXMLConSAX {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean nombre = false, edad = false, telefono = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    if (qName.equalsIgnoreCase("Nombre")) {
                        nombre = true;
                    } else if (qName.equalsIgnoreCase("Edad")) {
                        edad = true;
                    } else if (qName.equalsIgnoreCase("Telefono")) {
                        telefono = true;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    String contenido = new String(ch, start, length).trim();
                    if (nombre) {
                        System.out.println("Nombre: " + contenido);
                        nombre = false;
                    } else if (edad) {
                        System.out.println("Edad: " + contenido);
                        edad = false;
                    } else if (telefono) {
                        System.out.println("Teléfono: " + contenido);
                        telefono = false;
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) {
                    if (qName.equalsIgnoreCase("Persona")) {
                        System.out.println("-------------------");
                    }
                }
            };

            // Leer el archivo XML
            saxParser.parse("Personas.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


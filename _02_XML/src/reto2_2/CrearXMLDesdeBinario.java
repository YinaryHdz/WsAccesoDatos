package reto2_2;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class CrearXMLDesdeBinario {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FichPersona.dat"))) {
            // Crear el documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            // Nodo raíz
            Element root = doc.createElement("Personas");
            doc.appendChild(root);

            // Leer objetos del archivo binario
            while (true) {
                try {
                    Persona persona = (Persona) ois.readObject();

                    // Crear nodo Persona
                    Element personaElement = doc.createElement("Persona");
                    root.appendChild(personaElement);

                    // Crear subnodos
                    Element nombre = doc.createElement("Nombre");
                    nombre.setTextContent(persona.getNombre());
                    personaElement.appendChild(nombre);

                    Element edad = doc.createElement("Edad");
                    edad.setTextContent(String.valueOf(persona.getEdad()));
                    personaElement.appendChild(edad);

                    Element telefono = doc.createElement("Telefono");
                    telefono.setTextContent(persona.getTelefono());
                    personaElement.appendChild(telefono);
                } catch (Exception eof) {
                    break; // Fin del archivo
                }
            }

            // Guardar en un archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("Personas.xml");

            transformer.transform(source, result);
            System.out.println("Archivo Personas.xml generado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


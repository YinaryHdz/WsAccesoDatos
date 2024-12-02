package reto2_1;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
public class crearXMLDOM {

	 public static void main(String[] args) {
	        try {
	            // Crear una nueva instancia de DocumentBuilderFactory
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();

	            // Crear el documento XML
	            Document doc = builder.newDocument();

	            // Nodo raíz
	            Element almacen = doc.createElement("Almacen");
	            doc.appendChild(almacen);

	            // Producto 1
	            Element producto1 = doc.createElement("Producto");
	            producto1.setAttribute("Codigo", "1");
	            almacen.appendChild(producto1);

	            Element descripcion1 = doc.createElement("Descripcion");
	            descripcion1.setTextContent("Producto A");
	            producto1.appendChild(descripcion1);

	            Element origen1 = doc.createElement("Origen");
	            producto1.appendChild(origen1);

	            Element nombre1 = doc.createElement("Nombre");
	            nombre1.setTextContent("Empresa A");
	            origen1.appendChild(nombre1);

	            Element telefono1 = doc.createElement("Telefono");
	            telefono1.setTextContent("123456789");
	            origen1.appendChild(telefono1);

	            Element existencias1 = doc.createElement("Existencias");
	            existencias1.setTextContent("100");
	            producto1.appendChild(existencias1);

	            Element precio1 = doc.createElement("Precio");
	            precio1.setTextContent("25.50");
	            producto1.appendChild(precio1);

	            // Producto 2
	            Element producto2 = doc.createElement("Producto");
	            producto2.setAttribute("Codigo", "2");
	            almacen.appendChild(producto2);

	            Element descripcion2 = doc.createElement("Descripcion");
	            descripcion2.setTextContent("Producto B");
	            producto2.appendChild(descripcion2);

	            Element origen2 = doc.createElement("Origen");
	            producto2.appendChild(origen2);

	            Element nombre2 = doc.createElement("Nombre");
	            nombre2.setTextContent("Empresa B");
	            origen2.appendChild(nombre2);

	            Element telefono2 = doc.createElement("Telefono");
	            telefono2.setTextContent("987654321");
	            origen2.appendChild(telefono2);

	            Element existencias2 = doc.createElement("Existencias");
	            existencias2.setTextContent("50");
	            producto2.appendChild(existencias2);

	            Element precio2 = doc.createElement("Precio");
	            precio2.setTextContent("45.75");
	            producto2.appendChild(precio2);

	            // Guardar el documento en un archivo
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(new File("almacen.xml"));

	            transformer.transform(source, result);

	            System.out.println("Archivo almacen.xml generado.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}

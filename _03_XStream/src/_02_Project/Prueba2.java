package _02_Project;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Prueba2 {
    public static void main(String[] args) {
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypes(new Class[]{Libro.class, Autor.class});

        // Registrar alias
        xstream.alias("libro", Libro.class);
        xstream.alias("autor", Autor.class);

        Autor autor = new Autor("Juan");

        Libro libro = new Libro(1234, "Once", "Nova", 350, autor, 1000);

        String xml = xstream.toXML(libro);
        System.out.println("XML:\n" + xml);

        Libro libro2 = (Libro) xstream.fromXML(xml);
        System.out.println("Libro:  " + libro2);

    }
}

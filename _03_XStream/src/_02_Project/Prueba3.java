package _02_Project;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

import java.io.File;

public class Prueba3 {
    public static void main(String[] args) {
        XStream xstream1 = new XStream( new DomDriver());
        xstream1.allowTypes(new Class[]{_02_Project.Libro.class});
        xstream1.alias("Escritor", Autor.class);
        xstream1.aliasField("seudonimo", Autor.class, "nombre");
        XmlArrayList lista = new XmlArrayList(new FilePersistenceStrategy(new File("c://dir1"), xstream1));

        //Me crea un xml diferente para cada autor
        lista.add(new Autor("Camilo Jose Cela"));
        lista.add(new Autor("Tolkien"));
        lista.add(new Autor("Cervantes"));
        lista.add(new Autor("Quevedo"));



    }
}

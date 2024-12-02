package _02_Project;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

import java.io.File;
import java.util.Iterator;

public class Prueba4 {
    public static void main(String[] args) {
        XStream xstream1 = new XStream( new DomDriver());
        xstream1.allowTypes(new Class[]{Libro.class, Autor.class});
        xstream1.alias("Escritor", Autor.class);
        xstream1.aliasField("seudonimo", Autor.class, "nombre");
        XmlArrayList lista = new XmlArrayList(new FilePersistenceStrategy(new File("c://dir1"), xstream1));

        for(Iterator it = lista.iterator() ; it.hasNext();){
            Autor autor = (Autor) it.next();
            /*
            Con esto elimino a un elemento especifico de la lista  
            if(autor.getNombre().equals("Quevedo")){
                System.out.println("Borrando Quevedo");
                it.remove();
            }else{
                System.out.println("Manteniendo: " + autor.getNombre());
            }
            */
            System.out.println(autor.getNombre());
        }


    }
}

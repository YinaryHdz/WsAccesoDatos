package _05_anotaciones;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.Arrays;
import java.util.List;

public class PersonaMain {

    public static void main(String[] args) {
        Persona persona1 = new Persona("Alvaro",19,false);
        Persona persona2 = new Persona("Eduardo",22,false);
        List<Persona> personas = Arrays.asList(persona1, persona2);
        Grupo grupo = new Grupo(personas);
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypesByWildcard(new String[]{"xml.xstream.anotaciones.*"});
        xstream.processAnnotations(Persona.class);
        xstream.processAnnotations(Grupo.class);
        String xml = xstream.toXML(grupo);
        System.out.println(xml);

        Grupo grupoLeido = (Grupo) xstream.fromXML(xml);
        System.out.println(grupoLeido);
    }
}


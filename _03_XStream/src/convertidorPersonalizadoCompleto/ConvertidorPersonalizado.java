package convertidorPersonalizadoCompleto;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class ConvertidorPersonalizado {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setNombre("Ayoub1");
        persona.setApellido("Ben Hardon");
        XStream xStream = new XStream(new DomDriver());
        xStream.registerConverter(new PersonaConverter());
        xStream.alias("persona", Persona.class);
        System.out.println(xStream.toXML(persona));
    }
}


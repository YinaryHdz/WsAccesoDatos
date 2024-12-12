package convertidorPersonalizadoAtributo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.Date;

public class ConvertidorAtributo {
    public static void main(String[] args) {
        Telefono tel = new Telefono();
        tel.setCodigo(34);
        tel.setNumero(666666666);
        Persona persona = new Persona();
        persona.setNombre("Sergio");
        persona.setApellido("Ruiz");
        persona.setTelefono(tel);
        persona.setMayorEdad(true);
        persona.setPeso(75.0F);
        persona.setFecha(new Date());

        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypesByWildcard(new String[]{"xml.xstream.convertidorPersonalizadoAtributo.*"});

        xstream.alias("persona", Persona.class);
        xstream.aliasField("adulto", Persona.class, "mayorEdad");
        xstream.useAttributeFor(Persona.class, "nombre");
        xstream.useAttributeFor(Persona.class, "telefono");
        xstream.aliasAttribute("tel", "telefono");
        xstream.registerConverter(new BooleanConverter("si","no",false));
        xstream.registerConverter(new DateConverter("dd-MM-yyyy HH:mm:ss", null));
        xstream.registerConverter(new TelefonoConverter());
        String xml = xstream.toXML(persona);
        System.out.println(xml);

        Persona persona2 = (Persona) xstream.fromXML(xml);
        System.out.println(persona2);
    }
}


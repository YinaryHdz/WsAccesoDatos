package _01_project;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class Prueba {
    public static void main(String[] args) {
        XStream xstream  =new XStream(new StaxDriver());
        //xstream.addPermission(AnyTypePermission.ANy);
        xstream.allowTypes(new Class[]{Persona.class, Telefono.class});

        Telefono tel = new Telefono();
        tel.setCodigo(34);
        tel.setNumero(6666666);

        Persona persona = new Persona();
        persona.setNombre("Hari");
        persona.setApellido("Carbajal");
        persona.setTelefono(tel);

        String xml = xstream.toXML(persona);
        System.out.println("XML:\n" + xml);

        Persona persona2 = (Persona) xstream.fromXML(xml);
        System.out.println("Objeto Persona " + persona2);

    }
}

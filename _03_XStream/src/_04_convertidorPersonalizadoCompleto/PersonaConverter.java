package _04_convertidorPersonalizadoCompleto;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class PersonaConverter implements Converter {

    @Override
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Persona persona = (Persona) o;
        hierarchicalStreamWriter.addAttribute("apellidos", persona.getApellido());
        hierarchicalStreamWriter.startNode("nombre_completo");
        hierarchicalStreamWriter.setValue(persona.getNombre());
        hierarchicalStreamWriter.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Persona persona1 = new Persona();
        persona1.setApellido(hierarchicalStreamReader.getAttribute("apellidos"));
        hierarchicalStreamReader.moveDown();
        persona1.setNombre(hierarchicalStreamReader.getValue());
        hierarchicalStreamReader.moveUp();
        return persona1;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(Persona.class);
    }
}


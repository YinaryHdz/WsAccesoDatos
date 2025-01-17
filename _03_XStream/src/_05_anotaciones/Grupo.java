package _05_anotaciones;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;
/*
<xml.xstream.anotaciones.Grupo>
  <personas class="java.util.Arrays$ArrayList">
    <a class="persona-array">
      <persona nombre="Alvaro" casado="false">
        <edad>19</edad>
      </persona>
      <persona nombre="Eduardo" casado="false">
        <edad>22</edad>
      </persona>
    </a>
  </personas>
</xml.xstream.anotaciones.Grupo>

<xml.xstream.anotaciones.Grupo>
  <persona nombre="Alvaro" casado="false">
    <edad>19</edad>
  </persona>
  <persona nombre="Eduardo" casado="false">
    <edad>22</edad>
  </persona>
</xml.xstream.anotaciones.Grupo>
 */

public class Grupo {
    @XStreamImplicit //Genera solo las etiquetas necesarias
    List<Persona>personas;

    public Grupo(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "personas=" + personas +
                '}';
    }
}

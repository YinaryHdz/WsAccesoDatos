package _05_anotaciones;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/*
<xml.xstream.anotaciones.Persona>
  <nombre>Alvaro</nombre>
  <edad>19</edad>
  <casado>false</casado>
</xml.xstream.anotaciones.Persona>
 */
/*
<persona nombre="Alvaro" casado="false">
  <edad>19</edad>
</persona>
 */
@XStreamAlias("persona")
public class Persona {

    @XStreamAsAttribute
    String nombre;
    int edad;
    @XStreamAsAttribute
    boolean casado;

    public Persona(String nombre, int edad, boolean casado) {
        this.nombre = nombre;
        this.edad = edad;
        this.casado = casado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", casado=" + casado +
                '}';
    }
}


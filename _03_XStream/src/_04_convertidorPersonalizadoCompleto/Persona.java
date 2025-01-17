package _04_convertidorPersonalizadoCompleto;
import _03_convertidorPersonalizadoAtributo.Telefono;

/**
 *  @descrition Clase que representa una persona
 */

public class Persona {
    private String nombre;
    private String apellido;
    private Telefono telefono;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Telefono getTelefono() {
        return telefono;
    }
    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }
    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", apellido=" + apellido
                + ", telefono=" + telefono.toString() + "]";
    }
}


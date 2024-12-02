package reto2_2;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private int edad;
    private String telefono;

    public Persona(String nombre, int edad, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + ", telefono=" + telefono + "]";
    }
}
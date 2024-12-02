package reto2_2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CrearFichPersona {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Juan", 25, "123456789"));
        personas.add(new Persona("María", 30, "987654321"));
        personas.add(new Persona("Pedro", 35, "456123789"));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FichPersona.dat"))) {
            for (Persona persona : personas) {
                oos.writeObject(persona);
            }
            System.out.println("Fichero FichPersona.dat creado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

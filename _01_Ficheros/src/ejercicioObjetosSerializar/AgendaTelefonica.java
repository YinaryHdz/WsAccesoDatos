package ejercicioObjetosSerializar;

import java.io.Serializable;

public class AgendaTelefonica implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellidos;
	private int numeroTelefono;
	private String correoElectronico;
	public AgendaTelefonica(String nombre, String apellidos, int numeroTelefono, String correoElectronico) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.numeroTelefono = numeroTelefono;
		this.correoElectronico = correoElectronico;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	@Override
	public String toString() {
		return "AgendaTelefonica [nombre=" + nombre + ", apellidos=" + apellidos + ", numeroTelefono=" + numeroTelefono
				+ ", correoElectronico=" + correoElectronico + "]";
	}
	
	

}

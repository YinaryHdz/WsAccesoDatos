package _08_serializar;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Empleado implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private transient double sueldos;
	private Date fechaContrato;
	public Empleado(String nombre, double sueldo, int anio, int mes, int dia) {
		super();
		this.nombre = nombre;
		this.sueldos = sueldo;
		GregorianCalendar calendario = new GregorianCalendar(anio, mes -1, dia);
		this.fechaContrato = calendario.getTime();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSueldo() {
		return sueldos;
	}
	public void setSueldo(double sueldo) {
		this.sueldos = sueldo;
	}
	public Date getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", sueldo=" + sueldos + ", fechaContrato=" + fechaContrato + "]";
	}
}

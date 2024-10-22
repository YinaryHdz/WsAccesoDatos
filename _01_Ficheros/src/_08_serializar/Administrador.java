package _08_serializar;

public class Administrador extends Empleado {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double incentivo;

	public Administrador(String nombre, double sueldo, int anio, int mes, int dia, double incentivo) {
		super(nombre, sueldo, anio, mes, dia);
		this.incentivo = incentivo;
		// TODO Auto-generated constructor stub
	}

	public double getIncentivo() {
		return incentivo;
	}

	public void setIncentivo(double incentivo) {
		this.incentivo = incentivo;
	}

	@Override
	public String toString() {
		return "Administrador [incentivo=" + incentivo + ", getNombre()=" + getNombre() + ", getSueldo()="
				+ getSueldo() + ", getFechaContrato()=" + getFechaContrato() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}


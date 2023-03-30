package modelo;

public class Revision extends Trabajo {

	// ATRIBUTOS
	
	private final int IMPORTE_REVISION = 20;
	
	// CONSTRUCTORES
	
	protected Revision(String descripcion) {
		super(descripcion);
	}
	
	// METODOS

	@Override
	protected double calcularPrecioFinal() {
		
		double precioFinal = (this.numeroHoras * this.TARIFA_FIJA) + this.IMPORTE_REVISION;
		
		return precioFinal;
		
	}
	
	@Override
	public String toString() {
		return "REVISION\nTrabajo: " + ID + ".\nDescripcion: " + descripcion + ".\nPrecio del trabajo: " + calcularPrecioFinal() + ".\nEstado: " + estadoDelTrabajo() + ".\n";
	}
}

package modelo;

public class ReparacionChapaYPintura extends Reparacion {
	
	// ATRIBUTOS
	
	private final double MULTIPLICADOR_MATERIAL = 1.3;
	
	// CONSTRUCTORES
	
	protected ReparacionChapaYPintura(String descripcion) {
		super(descripcion);
	}	
	
	// METODOS
	
	/*
	 * metodo que calcula el precio de un trabajo
	 */
	@Override
	protected double calcularPrecioFinal() {
		
		double precioFinal = (this.numeroHoras * this.TARIFA_FIJA) + (this.precioMaterial * this.MULTIPLICADOR_MATERIAL);
		
		return precioFinal;
		
	}
	
	@Override
	public String toString() {
		return "REPARACION DE CHAPA Y PINTURA\nTrabajo: " + ID + ".\nDescripcion: " + descripcion + ".\nPrecio del trabajo: " + calcularPrecioFinal() + ".\nEstado: " + estadoDelTrabajo() + ".\n";
	}
	
}

package modelo;

public class ReparacionMecanica extends Reparacion {

	// ATRIBUTOS
	
	private final double MULTIPLICADOR_MATERIAL = 1.1;
	
	// CONSTRUCTORES
	
	protected ReparacionMecanica(String descripcion) {
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
		return "REPARACION MECANICA\nTrabajo: " + ID + ".\nDescripcion: " + descripcion + ".\nPrecio del trabajo: " + calcularPrecioFinal() + ".\nEstado: " + estadoDelTrabajo() + ".\n";
	}
	
	

}

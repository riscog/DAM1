package modelo;

public class ReparacionElectrica extends Reparacion {

	private final double ASISTENCIA_INGENIERO = 70;
	private final double MULTIPLICADOR_MATERIAL = 1.3;
	private String ingeniero;
	private String maquina;
	
	// CONSTRUCTORES
	
	protected ReparacionElectrica(String descripcion, String ingeniero, String maquina) {
		super(descripcion);
		this.ingeniero = ingeniero;
		this.maquina = maquina;
	}

	// METODOS
		
	/*
	 * metodo que calcula el precio de un trabajo
	 */
	@Override
	protected double calcularPrecioFinal() {
			
		double precioFinal = (this.numeroHoras * this.TARIFA_FIJA) + (this.precioMaterial * this.MULTIPLICADOR_MATERIAL) + this.ASISTENCIA_INGENIERO;
			
		return precioFinal;
			
	}
	
	@Override
	public String toString() {
		return "REPARACION ELECTRICA\nTrabajo: " + ID + ".\nDescripcion: " + descripcion + ".\nPrecio del trabajo: " + calcularPrecioFinal() + ".\nEstado: " + estadoDelTrabajo() + ".\n";
	}
	
}

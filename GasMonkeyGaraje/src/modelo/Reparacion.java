package modelo;

public abstract class Reparacion extends Trabajo {

	// ATRIBUTOS
	
	protected double precioMaterial;
	
	// CONSTRUCTORES
	
	protected Reparacion(String descripcion) {
		super(descripcion);
		this.precioMaterial = 0;
	}
	
	// GETTERS Y SETTERS
	
	public double getPrecioMaterial() {
		return precioMaterial;
	}

	public void setPrecioMaterial(double precioMaterial) {
		this.precioMaterial += precioMaterial;
	}
	
}

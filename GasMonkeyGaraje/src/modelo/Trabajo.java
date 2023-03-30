package modelo;

public abstract class Trabajo {

	// ATRIBUTOS
	
	protected final int ID;
	private static int contador = 0;
	protected final int TARIFA_FIJA = 30;
	protected int numeroHoras;
	protected String descripcion;
	private boolean finalizado;
	
	// CONSTRUCTORES
	
	protected Trabajo(String descripcion) {
		this.ID = this.contador++;
		this.descripcion = descripcion;
		this.finalizado = false;
	}
	
	// GETTERS Y SETTERS

	public int getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(int numeroHoras) {
		this.numeroHoras += numeroHoras;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado() {
		this.finalizado = true;
	}

	public int getId() {
		return ID;
	}
	
	// METODOS
	
	/*
	 * metodo que calcula el precio de un trabajo
	 */
	protected double calcularPrecioFinal() {
		
		double precioFinal = this.numeroHoras * this.TARIFA_FIJA;
		
		return precioFinal;
		
	}

	@Override
	public String toString() {
		return "Trabajo: " + ID + ".\nDescripcion: " + descripcion + ".\nPrecio del trabajo: " + calcularPrecioFinal() + ".\nEstado: " + estadoDelTrabajo() + ".\n";
	}
	
	/*
	 * metodo que devuelve el estado del trabajo (pendiente, en proceso o finalizado)
	 */
	protected String estadoDelTrabajo() {
		
		String estado = "";
		
		if ( numeroHoras == 0 ) {
			estado = "Pendiente";
		} else if ( numeroHoras > 0 ) {
			estado = "En proceso";
		}
		
		if ( isFinalizado() ) {
			estado = "Finalizado";
		}
		return estado;
	}
	
}

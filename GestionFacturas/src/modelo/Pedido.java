package modelo;

public class Pedido {

	// ATRIBUTOS
	
	private Producto producto;
	private int cantidad;
	
	// CONSTRUCTORES
	
	protected Pedido(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	// METODOS
	
	@Override
	public String toString() {
		return producto.toString() + "\t\t" + cantidad + " \t\t " + saberPrecio();
	}
	
	/*
	 * metodo que obtiene el precio total de una cantidad del producto
	 */
	protected double saberPrecio() {
		return this.producto.getPrecio() * this.cantidad;
	}

}

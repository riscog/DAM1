package modelo;

public class Producto {

	// ATRIBUTOS
	
	final private String nombre;
	int precio;
	
	// CONSTRUCTORES
	
	protected Producto(String nombre, int precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	// GETTERS Y SETTERS
	
	protected String getNombre() {
		return nombre;
	}
	
	protected int getPrecio() {
		return precio;
	}
	
	// METODOS
	
	@Override
	public String toString() {
		return nombre + "\t" + precio + " centimos\t";
	}
	
	/*
	 * metodo que comprueba el dinero introducido con el precio de un producto
	 * 
	 * 0 si son iguales
	 * 1 si el dinero introducido es mayor que el precio
	 * 2 si el dinero introducido es menor que el precio
	 */
	protected int comprobarPrecio(int dinero) {
		
		int codigo = 0;
		
		if ( dinero == this.precio ) {
			codigo = 0;
		} else if ( dinero > this.precio ) {
			codigo = 1;
		} else if ( dinero < this.precio ) {
			codigo = 2;
		}
		return codigo;
	}
	
}

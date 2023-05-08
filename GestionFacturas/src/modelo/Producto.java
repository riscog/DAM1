package modelo;

import java.util.Objects;

public class Producto {

	// ATRUBUTOS
	
	final private String nombre;
	private double precio;
	
	// CONSTRUCTORES
	
	protected Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	protected Producto(String nombre) {
		this.nombre = nombre;
	}
	
	// GETTERS Y SETTERS
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	// METODOS
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return nombre.equalsIgnoreCase(other.nombre);
	}

	@Override
	public String toString() {
		return String.format("%1$-20s", nombre) + " " + precio + "€";
	}
	
}

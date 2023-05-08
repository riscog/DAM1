package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AlmacenProductos {

	// ATRUBUTOS
	
	private Map<Producto, Integer> productos;
	
	// CONSTRUCTORES
	
	protected AlmacenProductos() {
		productos = new HashMap<Producto, Integer>();
	}
	
	// METODOS
	
	/*
	 * metodo que comprueba si existe un producto
	 * 		-devuelve una excepcion si no existe
	 */
	protected boolean existeProducto(Producto producto) {
		
		boolean existe = false;
		
		if ( productos.containsKey(producto) ) {
			existe = true;
		}
		return existe;
	}
	
	/*
	 * metodo que anniade un producto al almacen
	 */
	protected void anniadirProducto(Producto producto, int cantidad) {
		
		this.productos.put(producto, cantidad);
		
	}
	
	/*
	 * metodo que aumenta la cantidad deseada las unidades de un producto del almacen
	 */
	protected void aumentarCantidades(Producto producto, int cantidad) {
		
		int cantidadActual = productos.get(producto);
		int sumaCantidad = cantidadActual + cantidad;
		
		this.productos.replace(producto, sumaCantidad);
		
	}
	
	/*
	 * metodo que muestra por pantalla los productos del almacen
	 */
	protected String mostrarProductos() {
		
		String lista = "";
		
		for ( Entry<Producto, Integer> p : productos.entrySet() ) {
			lista += p.getKey().toString() + " | Cantidad: " + p.getValue() + "\n";
		}
		return lista;
	}
	
	/*
	 * metodo que reduce la cantidad de un producto del almacen al realizar un pedido
	 */
	protected void reducirCantidades(Producto producto, int cantidad) {
		
		int cantidadActual = productos.get(producto);
		int restaCantidad = cantidadActual - cantidad;
		
		this.productos.replace(producto, restaCantidad);
		
	}
	
	/*
	 * metodo que devuelve un producto del almacen si este existe
	 */
	protected Producto buscarProducto(String nombre) {
		
		Producto aux = new Producto(nombre);
		
		if ( this.productos.containsKey(aux) ) {
			for (Map.Entry<Producto, Integer> p : this.productos.entrySet()) {
	            if (aux.equals(p.getKey())) {
	                aux = p.getKey();
	            }
	        }
		}
		return aux;
	}
	
}

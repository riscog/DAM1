package modelo;

public class CajetinProductos {

	// ATRIBUTOS
	
	private Producto[] productos;
	private int[] cantidades;
	
	// CONSTRUCTORES
	
	protected CajetinProductos() {
		productos = new Producto[16];
		this.productos[0] = new Producto("Coca-cola", 120);
		this.productos[1] = new Producto("Agua", 80);
		this.productos[2] = new Producto("Fanta", 80);
		this.productos[3] = new Producto("Red Bull", 160);
		
		cantidades = new int[productos.length];
		cantidadesA10();
	}
	
	// METODOS
	
	/*
	 * metodo que pone la cantidad de cada producto a 10
	 */
	private void cantidadesA10() {
		
		for ( int contador = 0; contador < this.cantidades.length; contador++ ) {
			
			cantidades[contador] = 10;
			
		}
	}
	
	/*
	 * metodo que muestra por pantalla los productos del cajetin
	 */
	protected String mostrarProductos() {
		
		String lista = "";
		
		for ( int contador = 0; contador < this.productos.length; contador++ ) {
			
			if ( this.productos[contador] != null ) {
			
				lista += contador + ".\t" + productos[contador].toString() + "\n";
				
			}			
		}
		return lista;
	}
	
	/*
	 * metodo que mira si un producto existe en el cajetin
	 */
	protected boolean existeProducto(int n) {
		
		boolean encontrado = false;
		
		for ( int contador = 0; contador < this.productos.length && !encontrado; contador++ ) {
			if ( n == contador ) {
				encontrado = true;
			}
		}
		return encontrado;
	}
	
	/*
	 * metodo que devuelve un String con el nombre del metodo deseado
	 */
	protected String nombreProducto(int n) {
		
		String aux = "";
		
		for ( int contador = 0; contador < this.productos.length; contador++ ) {
			if ( n == contador ) {
				aux = this.productos[contador].getNombre();
			}
		}
		return aux;
	}
	
	/*
	 * metodo que encuentra un producto en el caetin y lo devuelve
	 */
	protected Producto saberProducto(int n) {
		
		Producto aux = null;
		
		for ( int contador = 0; contador < this.productos.length; contador++ ) {
			if ( n == contador ) {
				aux = productos[contador];
				break;
			}
		}
		return aux;
	}
	
	/*
	 * metodo que compara el dinero introducido con el precio del producto
	 */
	protected int compararPrecio(int n, int dinero) {
		
		return saberProducto(n).comprobarPrecio(dinero);
		
	}
	
	/*
	 * metodo que reduce la cantidad de un producto al comprarlo
	 */
	protected void reducirCantidad(int n) {
		
		if ( existeProducto(n) ) {
			this.cantidades[n]--;
		}
	}
	
	/*
	 * metodo que devuelve el cambio a devolver
	 */
	protected int saberCambio(int n, int dinero) {
		
		return dinero - saberProducto(n).getPrecio();
		
	}
	
	/*
	 * metodo que permite al admin meter productos en el cajetin
	 */
	protected int meterProductos(int n, int cantidad) {
		
		int codigo = 0;
		
		if ( existeProducto(n) ) {
			this.cantidades[n] += cantidad;
		} else {
			codigo = -1;
		}
		return codigo;
	}
	
}

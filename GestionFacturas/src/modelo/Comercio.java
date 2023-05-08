package modelo;

import java.util.HashMap;
import java.util.Map;

import excepciones.*;

public class Comercio {

	// ATRIBUTOS
	
	private AlmacenProductos almacen;
	private Map<Integer, Factura> facturas;
	private Map<String, Cliente> clientes;
	
	// CONSTRUCTORES
	
	public Comercio() {
		this.almacen = new AlmacenProductos();
		this.facturas = new HashMap<Integer, Factura>();
		this.clientes = new HashMap<String, Cliente>();
	}
	
	// METODOS
	
	/*
	 * metodo que añade un cliente al sistema
	 * 		-devuelve una excepcion si el cliente ya existe
	 */
	public void registrarCliente(String dni, String nombre, String apellidos, int telefono, int descuento) throws YaExisteCliente {
		
		Cliente aux = new Cliente(dni, nombre, apellidos, telefono, descuento);
		
		if ( clientes.containsKey(dni) ) {
			throw new YaExisteCliente();
		} else {
			this.clientes.put(dni, aux);
		}
		
	}
	
	/*
	 * metodo que añade un cliente al sistema
	 * 		-devuelve una excepcion si el cliente ya existe
	 */
	public void registrarCliente(String dni, String nombre, int descuento) throws YaExisteCliente {
		
		Cliente aux = new Cliente(dni, nombre, descuento);
		
		if ( clientes.containsKey(dni) ) {
			throw new YaExisteCliente();
		} else {
			this.clientes.put(dni, aux);
		}
		
	}
	
	/*
	 * metodo que añade un producto al almacen de productos
	 * 		-devuelve una excepcion si el producto ya existe
	 */
	public void nuevoProducto(String nombre, double precio, int cantidad) throws YaExisteProducto {
		
		Producto aux = new Producto(nombre, precio);
		
		if ( almacen.existeProducto(aux) ) {
			throw new YaExisteProducto();
		} else {
			this.almacen.anniadirProducto(aux, cantidad);
		}
		
	}
	
	/*
	 * metodo que añade las cantidades deseadas de un producto al almacen de productos
	 * 		-devuelve una excepcion si el producto no existe
	 */
	public void reposicionExistencias(String nombre, int cantidad) throws NoExisteProducto {
		
		Producto aux = new Producto(nombre);
		
		if ( !almacen.existeProducto(aux) ) {
			throw new NoExisteProducto();
		} else {
			this.almacen.aumentarCantidades(aux, cantidad);
		}
		
	}
	
	/*
	 * metodo que devuelve un cliente segun el dni intruducido
	 */
	private Cliente obtenerCliente(String dni) {
		
		return this.clientes.get(dni);
		
	}
	
	/*
	 * metodo que comprueba si un cliente existe
	 * 		-devuelve una excepcion si no existe
	 */
	public boolean existeCliente(String dni) throws NoExisteCliente {
		
		if ( !clientes.containsKey(dni) ) {
			throw new NoExisteCliente();
		} else {
			return true;
		}
	}
	
	/*
	 * metodo que muestra por pantalla los productos del almacen
	 */
	public String mostrarProductos() {
		
		return this.almacen.mostrarProductos();
		
	}
	
	/*
	 * metodo que comprueba si un producto existe
	 * 		-devuelve una excepcion si no existe
	 */
	public boolean existeProducto(String nombre) throws NoExisteProducto {
		
		Producto aux = new Producto(nombre);
		
		if ( !almacen.existeProducto(aux) ) {
			throw new NoExisteProducto();
		} else {
			return true;
		}
		
	}
	
	private Producto buscarProducto(String nombre) {
		
		return this.almacen.buscarProducto(nombre);
		
	}
	
	/*
	 * metodo que genera un pedido ligado a un cliente
	 */
	public void generarPedido(String dni, String nombreProducto, int cantidad) {
			
		Producto aux = buscarProducto(nombreProducto);
				
		this.almacen.reducirCantidades(aux, cantidad);
				
		Cliente cliente = obtenerCliente(dni);
				
		cliente.anniadirPedido(aux, cantidad);
		
	}
	
	/*
	 * metodo que genera una factura ligada a un cliente
	 * 		-devuelve una excepcion si el cliente no existe
	 */
	public String gererarFactura(String dni) {
			
		Cliente cliente = obtenerCliente(dni);
		Factura aux = new Factura(cliente);
		aux.recibirPedidos(cliente);
		this.facturas.put(aux.getNumero(), aux);
		cliente.limpiarListaPedidos();
		cliente.anniadirFactura(aux);
		
		return "Factura generada con exito. Nº de Factura: " + aux.getNumero();
	}
	
	/*
	 * metodo que muestra por pantalla una factura
	 * 		-devuelve una excepcion si la factura no existe
	 */
	public String visualizarFactura(int numero) throws NoExisteFactura {
		
		String factura = "";
		
		if ( !facturas.containsKey(numero) ) {
			throw new NoExisteFactura();
		} else {
			factura = this.facturas.get(numero).toString();
		}
		return factura;
	}
	
	/*
	 * metodo que muestra por pantalla todas las facturas de un cliente
	 * 		-devuelve una excepcion si el cliente no existe
	 */
	public String visualizarFacturasCliente(String dni) throws NoExisteCliente {
		
		String facturas = "";
		
		if ( !clientes.containsKey(dni) ) {
			throw new NoExisteCliente();
		} else {
			Cliente cliente = obtenerCliente(dni);
			
			facturas = cliente.mostrarFacturas();
		}
		return facturas;
	}
	
}

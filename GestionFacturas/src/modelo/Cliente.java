package modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {

	// ATRIBUTOS
	
	final private String dni;
	private String nombre, apellidos;
	private int telefono, descuento;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Factura> facturas;
	
	// CONSTRUCTORES
	
	protected Cliente(String dni, String nombre, String apellidos, int telefono, int descuento) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.descuento = descuento;
		this.pedidos = new ArrayList<Pedido>();
		this.facturas = new ArrayList<Factura>();
	}
	
	protected Cliente(String dni, String nombre, int descuento) {
		this.nombre = nombre;
		this.dni = dni;
		this.descuento = descuento;
		this.pedidos = new ArrayList<Pedido>();
		this.facturas = new ArrayList<Factura>();
	}
	
	// GETTERS Y SETTERS
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}
	
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public int getDescuento() {
		return descuento;
	}

	// METODOS
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}
	
	/*
	 * metodo que anniade un pedido al arrayListe de pedidos de un cliente
	 */
	protected void anniadirPedido(Producto producto, int cantidad) {
		
		Pedido aux = new Pedido(producto, cantidad);
		
		this.pedidos.add(aux);
		
	}
	
	/*
	 * metodo que limpia todos los pedidos del arrayList
	 */
	protected void limpiarListaPedidos() {
		
		this.pedidos.clear();
		
	}
	
	/*
	 * metodo que anniade una factura al arrayList de facturas de un cliente
	 */
	protected void anniadirFactura(Factura factura) {
		
		this.facturas.add(factura);
		
	}
	
	/*
	 * metodo que devuelve todas las facturas pertenecientes a un cliente
	 */
	protected String mostrarFacturas() {
		
		String lista = "";
		
		for ( Factura f : this.facturas ) {
			lista += f.toString() + "\n";
		}
		return lista;
	}
	
	/*
	 * metodo que devuelve un arrayList con los pedidos de un cliente
	 */
	protected ArrayList<Pedido> devolverPedidos() {
		
		ArrayList<Pedido> aux = (ArrayList<Pedido>) this.pedidos.clone();
		
		return aux;
		
	}
	
}

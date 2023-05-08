package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Factura {

	// ATRIBUTOS
	
	final private int numero;
	private Cliente cliente;
	ArrayList<Pedido> pedidos;
	
	// CONSTRUCTORES
	
	protected Factura(Cliente cliente) {
		this.numero = generarNumero();
		this.cliente = cliente;
		this.pedidos = new ArrayList<Pedido>();
	}
	
	// GETTERS Y SETTERS

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNumero() {
		return numero;
	}
	
	// METODOS

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		return numero == other.numero;
	}
	
	/*
	 * metodo que genera un numero con el dia, el mes, la hora, los minutos y los segundos actuales en el momento de generar la factura
	 */
	private int generarNumero() {
		
		LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("ddMMHHmmss");
        int numero = Integer.parseInt(fecha.format(fechaFormateada));
		
		return numero;
	}
	
	/*
	 * metodo que recibe los pedidos del cliente para almacenarlos en la factura
	 */
	protected void recibirPedidos(Cliente cliente) {
		
		this.pedidos = cliente.devolverPedidos();
		 
	}
	
	/*
	 * metodo que devuelve la lista de pedidos almacenados en la factura
	 */
	private String listaPedidos() {
		
		String lista = "";
		
		for ( Pedido p : this.pedidos ) {
			lista += p.toString() + "\n";
		}
		return lista;
	}
	
	/*
	 * metodo que suma los precios de todos los pedidos de la factura y le aplica el descuento del cliente
	 */
	protected double sumarPrecios() {
		
		double suma = 0;
		
		for ( Pedido p : this.pedidos ) {
			suma += p.saberPrecio();
		}
		return Math.round(((suma - (suma * this.cliente.getDescuento() / 100)) * 100.0) / 100.0);
	}
	
	/*
	 * metodo que calcula el IVA a partir del precio total de los pedidos
	 */
	protected double calcularIVA() {
		
		return Math.round(((sumarPrecios() * 21 / 100) * 100.0) / 100.0);
		
	}
	
	/*
	 * metodo que calcula el precio final de la factura
	 */
	protected double calcularPrecioFinal() {
		
		return Math.round(((sumarPrecios() + calcularIVA()) * 100.0) / 100.0);

	}

	@Override
	public String toString() {
		
		String factura = "+-----------------------------------------------------------------+\n";
		factura += "Cliente: " + this.cliente.getNombre() + " ";
		if ( this.cliente.getApellidos() != null ) {
			factura += this.cliente.getApellidos() + "\n";
		} else {
			factura += "\n";
		}
		factura += "Nº Factura: " + this.numero + "\n";
		factura += "Descuento del cliente: " + this.cliente.getDescuento() + "%\n\n";
		factura += "Producto \t    Precio \t    Unidades \t\tSubtotal\n";
		factura += "+-----------------------------------------------------------------+\n";
		factura += listaPedidos() + "\n";
		factura += "Subtotal \t\t\t\t\t\t " + sumarPrecios() + "\n";
		factura += "IVA 21%  \t\t\t\t\t\t " + calcularIVA() + "\n";
		factura += "TOTAL    \t\t\t\t\t\t " + calcularPrecioFinal() + "\n";
		factura += "+-----------------------------------------------------------------+\n";
		
		return factura;
	}
	
}

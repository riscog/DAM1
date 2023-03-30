package modelo;

public class Maquina {

	// ATRIBUTOS
	
	private CajetinProductos cajetinProductos;
	private CajetinMonedas cajetinMonedas;
	private Acumulador acumulador;
	
	// CONSTRUCTORES
		
	public Maquina() {
		this.cajetinProductos = new CajetinProductos();
		this.cajetinMonedas = new CajetinMonedas();
		this.acumulador = new Acumulador();
	}	
		
	// METODOS
		
	/*
	 * metodo que muestra los productos de la maquina por pantalla
	 */
	public String mostrarProductos() {
		
		return this.cajetinProductos.mostrarProductos();
		
	}
	
	/*
	 * metodo que mira si un producto existe en la maquina
	 */
	public boolean existeProducto(int n) {
		
		return this.cajetinProductos.existeProducto(n);
		
	}
	
	/*
	 * metodo que devuelve un String con el nombre del producto deseado
	 */
	public String nombreProducto(int n) {
		
		return this.cajetinProductos.nombreProducto(n);
		
	}
	
	/*
	 * metodo que comprueba si el numero introducido coincide con la contraseña del admin
	 */
	public boolean comprobarContrasennia(int n) {
		
		if ( n == 7777 ) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/*
	 * metodo que comprueba si el dinero introducido es igual al precio del producto
	 */
	public int compararPrecio(int n, int dinero) {
		
		return this.cajetinProductos.compararPrecio(n, dinero);
		
	}
	
	/*
	 * metodo que reduce la cantidad de un producto al comprarlo
	 */
	public void reducirCantidad(int n) {
		
		this.cajetinProductos.reducirCantidad(n);
		
	}
	
	/*
	 * metodo que muestra el dinero introducido para comprar un producto
	 */
	public int mostrarDineroIntroducido() {
		
		return this.acumulador.sumarAcumulador();
		
	}
	
	/*
	 * metodo que almacena el dinero introducido en un cajetin temporal de monedas
	 */
	public int almacenarEnAcumulador(int dinero) {
		
		return this.acumulador.almacenarMonedas(dinero);
		
	}
	
	/*
	 * metodo que pone a null el acumulador temporal
	 */
	public void acumuladorA0() {
		
		this.acumulador.cantidadesA0();
		
	}
	
	/*
	 * metodo que almacena las monedas del acumulador en el cajetin de monedas despues de comprar un producto
	 */
	public void almacenarEnCajetin() {
		
		int[] aux = this.acumulador.devolverCantidadesAcumulador();
		
		this.cajetinMonedas.recibirAcumulador(aux);
		
	}
	
	/*
	 * metodo que devuelve las monedas que hay en el acumulador
	 */
	public String devolverMonedasAcumulador() {
		
		return this.acumulador.devolverMonedas();
		
	}
	
	/*
	 * metodo que suma en un array las cantidades de cada moneda del acumulador y el cajetin
	 */
	private int[] sumarCantidades() {
		
		int[] cantidadesCajetin = this.cajetinMonedas.devolverCantidadesCajetin();
		int[] cantidadesAcumulador = this.acumulador.devolverCantidadesAcumulador();
		int[] sumaCantidades = new int[5];
		
		for ( int contador = 0; contador < cantidadesCajetin.length; contador++ ) {
			
			sumaCantidades[contador] = cantidadesCajetin[contador] + cantidadesAcumulador[contador];
			
		}
		return sumaCantidades;
	}
	
	/*
	 * metodo que devuelve el cambio (si es posible) al usuario
	 */
	public String devolverCambio(int n, int dinero) {
		
		String resultado = "";
		int[] aux = this.sumarCantidades();
		int cambio = this.cajetinProductos.saberCambio(n, dinero);
		
		if ( this.cajetinMonedas.existeCambio(cambio, aux) ) {
			resultado = "\nCambio:\n";
			almacenarEnCajetin();
			resultado += this.cajetinMonedas.devolverCambio(cambio);
		} else {
			resultado = "\nNo es posible devolver el cambio, se devolveran las monedas introducidas\n";
			resultado += devolverMonedasAcumulador();
			this.acumuladorA0();
		}
		return resultado;
	}
	
	/*
	 * metodo que devuelve las monedas que hay en el cajetin
	 */
	public String saberMonedasCajetin() {
		
		return this.cajetinMonedas.devolverMonedas();
		
	}
	
	/*
	 * metodo que comprueba si una moneda existe
	 */
	public boolean existeMoneda(int valor) {
		
		return this.cajetinMonedas.comprobarValor(valor);
		
	}
	
	/*
	 * metodo que permite al admin meter cambios en el cajetin de monedas
	 */
	public int meterCambios(int valor, int cantidad) {
		
		return this.cajetinMonedas.meterCambios(valor, cantidad);
		
	}
	
	/*
	 * metodo que permite al admin meter cambios en el cajetin de productos
	 */
	public int meterProductos(int n, int cantidad) {
		
		return this.cajetinProductos.meterProductos(n, cantidad);
		
	}
	
}

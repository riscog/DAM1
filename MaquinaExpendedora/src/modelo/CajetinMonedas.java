package modelo;

public class CajetinMonedas {

	// ATRIBUTOS
	
	private Moneda[] monedas;
	private int[] cantidades;
	
	// CONSTRUCTORES
	
	protected CajetinMonedas(){
		monedas = new Moneda[5];
		this.monedas[0] = new Moneda(10);
		this.monedas[1] = new Moneda(20);
		this.monedas[2] = new Moneda(50);
		this.monedas[3] = new Moneda(100);
		this.monedas[4] = new Moneda(200);
		
		cantidades = new int[monedas.length];
		cantidadesA40();
	}
	
	// METODOS
	
	/*
	 * metodo que pone la cantidad de cada moneda a 40
	 */
	private void cantidadesA40() {
		
		for ( int contador = 0; contador < this.cantidades.length; contador++ ) {
			
			cantidades[contador] = 40;
			
		}
	}
	
	/*
	 * metodo que comprueba si el valor introducido coincide con el valor de alguna moneda
	 */
	protected boolean comprobarValor(int valor) {
		
		boolean valido = false;
		
		for ( int contador = 0; contador < monedas.length; contador ++ ) {
			
			if ( valor == monedas[contador].getValor() ) {
				valido = true;
				break;
			}
		}
		return valido;
	}
	
	/*
	 * metodo que recibe las monedas del acumulador tras la compra de un producto
	 */
	protected void recibirAcumulador(int[] aux) {
		
		for ( int contador = 0; contador < aux.length; contador++ ) {
				
			this.cantidades[contador] += aux[contador];
		}
	}
	
	/*
	 * metodo que devuelve un array con la cantidad de cada moneda que hay en el cajetin
	 */
	protected int[] devolverCantidadesCajetin() {
		
		int[] aux = this.cantidades;
		
		return aux;
		
	}
	
	/*
	 * metodo que comprueba si es posible devolver el cambio al usuario
	 */
	protected boolean existeCambio(int cambio, int[] arrayAux) {
		
		boolean listo = false;
		
		for ( int contador = this.monedas.length - 1; contador >= 0 && !listo; ) {
			
			int aux = 0;
			
			while ( this.monedas[contador].getValor() <= cambio && arrayAux[contador] - aux > 0 ) {
				cambio -= monedas[contador].getValor();
				aux++;
			}
				
			if ( cambio == 0 ) {
				listo = true;
			} else {
				contador--;
			}
		}
		return listo;
	}
	
	/*
	 * metodo que devuelve el cambio al usuario
	 */
	protected String devolverCambio(int cambio) {
		
		boolean listo = false;
		String lista = "";
		
		for ( int contador = this.monedas.length - 1; !listo; ) {
			
			int aux = 0;
			
			while ( this.monedas[contador].getValor() <= cambio && this.cantidades[contador] > 0 ) {
				
				this.cantidades[contador]--;
				cambio -= monedas[contador].getValor();
				aux++;
				
			}
			
			if ( aux > 0 ) {
				lista += aux + " " + this.monedas[contador].toString() + "\n";
			}
				
			if ( cambio == 0 ) {
				listo = true;
			} else {
				contador--;
			}
			
		}
		return lista;
	}
	
	/*
	 * metodo que devuelve las monedas que hay en el cajetin
	 */
	protected String devolverMonedas() {
		
		String lista = "";
		
		for ( int contador = 0; contador < monedas.length; contador++ ) {
			
			if ( cantidades[contador] > 0 ) {
				lista += cantidades[contador] + " " + monedas[contador].toString() + "\n";
			}
		}
		return lista;
	}
	
	/*
	 * metodo que devuelve la posicion de una moneda segun un valor introducido como parametro
	 */
	protected int saberMoneda(int valor) {
		
		int posicion = 100;
		
		for ( int contador = 0; contador < this.monedas.length; contador++ ) {
			
			if ( this.monedas[contador].getValor() == valor ) {
				posicion = contador;
			}
		}
		return posicion;
	}
	
	/*
	 * metodo que permite al admin meter cambios en el cajetin
	 */
	protected int meterCambios(int valor, int cantidad) {
		
		int codigo = 0;
		
		if ( comprobarValor(valor) ) {
			this.cantidades[saberMoneda(valor)] += cantidad;	
		} else {
			codigo = -1;	
		}
		return codigo;
	}

}

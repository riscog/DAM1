package modelo;

public class Acumulador {

	// ATRIBUTOS
	
	private Moneda[] monedasIntroducidas;
	private int[] cantidades;
	
	// CONSTRUCTORES
	
	protected Acumulador() {
		monedasIntroducidas = new Moneda[5];
		this.monedasIntroducidas[0] = new Moneda(10);
		this.monedasIntroducidas[1] = new Moneda(20);
		this.monedasIntroducidas[2] = new Moneda(50);
		this.monedasIntroducidas[3] = new Moneda(100);
		this.monedasIntroducidas[4] = new Moneda(200);
		
		cantidades = new int[monedasIntroducidas.length];
		cantidadesA0();
	}
	
	// METODOS
	
	/*
	 * metodo que pone la cantidad de cada moneda a 0
	 */
	protected void cantidadesA0() {
		
		for ( int contador = 0; contador < this.cantidades.length; contador++ ) {
			
			cantidades[contador] = 0;
			
		}
	}
	
	/*
	 * metodo que comprueba si el valor introducido coincide con el valor de alguna moneda
	 */
	protected boolean comprobarValor(int valor) {
		
		boolean valido = false;
		
		for ( int contador = 0; contador < monedasIntroducidas.length; contador ++ ) {
			
			if ( valor == monedasIntroducidas[contador].getValor() ) {
				valido = true;
				break;
			}
		}
		return valido;
	}
	
	/*
	 * metodo que devuelve la posicion donde almacenar el dinero introducido
	 */
	protected int saberPosicion(int dinero) {
		
		int codigo = 0;
		
		for ( int contador = 0; contador < this.monedasIntroducidas.length; contador++ ) {
			if ( monedasIntroducidas[contador].getValor() == dinero ) {
				codigo = contador;
				break;
			}
		}
		return codigo;
	}
	
	/*
	 * metodo que segun el codigo de error del metodo anterior realiza una accion
	 * 
	 * 0 si la moneda es valida
	 * -1 si no es valida
	 */
	protected int almacenarMonedas(int dinero) {
		
		int contador = saberPosicion(dinero);
		int codigo = 0;
		
		if ( comprobarValor(dinero) ) {
			this.cantidades[contador]++;
		} else {
			codigo = -1;
		}
		return codigo;
	} 
	
	/*
	 * metodo que devuelve el array de monedas del acumulador
	 */
	protected int[] devolverCantidadesAcumulador() {
		
		int[] aux = this.cantidades;
	
		return aux;
	}
	
	/*
	 * metodo que obtiene el dinero que hay en el acumulador
	 */
	protected int sumarAcumulador() {
		
		int suma = 0;
		
		for ( int contador = 0; contador < this.monedasIntroducidas.length; contador++ ) {
			
			suma += monedasIntroducidas[contador].getValor() * cantidades[contador];
	
		}
		return suma;
	}
	
	/*
	 * metodo que devuelve las monedas introducidas
	 */
	protected String devolverMonedas() {
		
		String lista = "";
		
		for ( int contador = 0; contador < monedasIntroducidas.length; contador ++ ) {
			
			if ( cantidades[contador] > 0 ) {
				lista += cantidades[contador] + " " + monedasIntroducidas[contador].toString() + "\n";
			}
		}
		return lista;
	}
	
}

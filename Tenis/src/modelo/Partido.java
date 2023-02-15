package modelo;

public class Partido {

	//ATRIBUTOS
	
	private Equipo e1, e2;
	
	//CONSTRUCTORES
	
	public Partido(String nombreE1, String nombreJ1, String nombreJ2, String nombreE2, String nombreJ3, String nombreJ4) {
		this.e1 = new Equipo(nombreE1, nombreJ1, nombreJ2);
		this.e2 = new Equipo(nombreE2, nombreJ3, nombreJ4);
	}
	
	//METODOS
	
	/*
	 * metodo que permite saber si un jugador existe
	 */
	private boolean existeJugador(String nombre) {
		
		if ( e1.existeJugador(nombre) || e2.existeJugador(nombre) ) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * metodo que devuelve el equipo en el que se encuentra el jugador
	 */
	private Equipo equipoDelJugador(String nombre) {
		
		Equipo equipo = null;
		
		if ( e1.existeJugador(nombre) ) {
			equipo = e1;
		} else if ( e2.existeJugador(nombre) ) { 
			equipo = e2;
		}
		return equipo;
	}

	/*
	 * metodo que permite saber si un equipo existe
	 */
	private boolean existeEquipo(String nombre) {
		
		Equipo e = new Equipo(nombre);
		
		if ( e1.equals(e) || e2.equals(e) ) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * metodo que devuelve el equipo segun un nombre pasado por teclado
	 */
	private Equipo saberEquipo(String nombre) {
		
		Equipo equipo = null;
		
		if ( e1.mismoNombre(nombre) ) {
			equipo = e1;
		} else if ( e2.mismoNombre(nombre) ) {
			equipo = e2;
		}
		return equipo; 
	}
	
	/*
	 * metodo que añade al jugador un punto, un error o un saque segun la opcion que se mete por teclado
	 * 
	 * devuelve 1 si el jugador añade punto
	 * devuelve 2 si el jugador añade error
	 * devuelve 3 si el jugador añade saque
	 * devuelve -1 si el jugador no existe
	 */
	public int contabiliza(String nombre, int opcion) {
		
		int codigo = -1;
		
		if ( existeJugador(nombre) ) {
			if ( opcion == 1 ) {
				equipoDelJugador(nombre).contabiliza(nombre, 1);
				codigo = 1;
			} else if ( opcion == 2 ) {
				equipoDelJugador(nombre).contabiliza(nombre, 2);
				codigo = 2;
			} else if ( opcion == 3  ) {
				equipoDelJugador(nombre).contabiliza(nombre, 3);
				codigo = 3;
			}
		} else {
			codigo = -1;
		}
		return codigo;
	}
	
	/*
	 * metodo que muestra por pantalla las estadisticas de un jugador
	 */
	public String estadisticasJugador(String nombre) {
		
		if ( existeJugador(nombre) ) {
			return equipoDelJugador(nombre).estadisticasJugador(nombre);
		} else {
			return "¡El jugador no existe!";
		}
	}
	
	/*
	 * metodo que muestra por pantalla las estadisticas de un equipo
	 */
	public String estadisticasEquipo(String nombre) {
		
		if ( existeEquipo(nombre) ) {
			return saberEquipo(nombre).estadisticasEquipo();
		} else {
			return "¡El equipo no existe!";
		}
	}
	
	/*
	 * metodo que comprueba si los puntos del primer equipo es mayor igual que el limite del partido, para que este finalice
	 */
	public boolean ganaE1(int limitePartido) {
		
		if ( e1.sumarPuntos() >= limitePartido ) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * metodo que comprueba si los puntos del segundo equipo es mayor igual que el limite del partido, para que este finalice
	 */
	public boolean ganaE2(int limitePartido) {
		
		if ( e2.sumarPuntos() >= limitePartido ) {
			return true;
		} else {
			return false;
		}
	}
}

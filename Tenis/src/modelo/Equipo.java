package modelo;
import java.util.Objects;

public class Equipo {

	//ATRIBUTOS
	
	final private String nombre;
	private Jugador j1, j2;
	
	//CONSTRUCTORES
	
	protected Equipo(String nombre) {
		this.nombre = nombre;
	}
	
	public Equipo(String nombre, String nombreJ1, String nombreJ2) {
		this.nombre = nombre;
		this.j1 = new Jugador(nombreJ1);
		this.j2 = new Jugador(nombreJ2);
	}
	
	// GETTERS Y SETTERS
	
	public String getNombre() {
		return nombre;
	}
	
	//METODOS

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	/*
	 * metodo que devuelve el jugador dentro del equipo
	 */
	protected boolean existeJugador(String nombre) {
		
		Jugador j = new Jugador(nombre);
		
		if ( this.j1.equals(j) || this.j2.equals(j) ) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * metodo que devuelve el jugador deseado
	 */
	protected Jugador saberJugador(String nombre) {
		
		Jugador jugador = null;
		
		if ( j1.mismoNombre(nombre) ) {
			jugador = j1;
		} else if ( j2.mismoNombre(nombre) ) {
			jugador = j2;
		}
		return jugador;
	}
	
	/*
	 * metodo que contabiliza punto, error o saque en un jugador
	 */
	protected void contabiliza(String nombre, int codigo) {
		
		if ( codigo == 1 ) {
			saberJugador(nombre).contabilizarPunto();
		} else if ( codigo == 2 ) {
			saberJugador(nombre).contabilizarError();
		} else if ( codigo == 3 ) {
			saberJugador(nombre).contabilizarSaque();
		}
		
	}
	
	/*
	 * metodo para mostrar por pantalla las estadisticas de un jugador
	 */
	protected String estadisticasJugador(String nombre) {
		
		return saberJugador(nombre).toString();
		
	}
	
	/*
	 * metodo que suma las estadisticas de los dos jugadores del equipo
	 */
	protected String estadisticasEquipo() {
		
		return nombre + " | Puntos ganadores: " + sumarPuntos() + " | Errores no forzados: " + 
		(j1.getErroresNoForzados() + j2.getErroresNoForzados()) + " | Saques directos: " + (j1.getSaqueDirecto() + j2.getSaqueDirecto()) + ".";
		
	}
	
	/*
	 * metodo que suma los puntos ganadores de los dos jugadores del equipo
	 */
	protected int sumarPuntos() {
		
		return j1.getPuntosGanadores() + j2.getPuntosGanadores();
		
	}
	
	/*
	 * metodo que compara el nombre introducido por teclado con el nombre del equipo
	 */
	protected boolean mismoNombre(String nombre) {
		
		if ( this.nombre.equals(nombre) ) {
			return true;
		} else {
			return false;
		}
	}
	
	
}

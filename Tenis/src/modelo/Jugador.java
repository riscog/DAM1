package modelo;

import java.util.Objects;

public class Jugador {

	//ATRIBUTOS
	
	final private String nombre;
	private int puntosGanadores, erroresNoForzados, saqueDirecto;
	
	//CONSTRUCTORES
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntosGanadores = 0;
		this.erroresNoForzados = 0;
		this.saqueDirecto = 0;
	}
	
	//GETTERS Y SETTERS
	
	public String getNombre() {
		return nombre;
	}
	
	protected int getPuntosGanadores() {
		return puntosGanadores;
	}

	protected int getErroresNoForzados() {
		return erroresNoForzados;
	}

	protected int getSaqueDirecto() {
		return saqueDirecto;
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
		Jugador other = (Jugador) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public String toString() {
		return nombre + " | Puntos ganadores: " + puntosGanadores + " | Errores no forzados: "
				+ erroresNoForzados + " | Saques directo: " + saqueDirecto + ".";
	}

	/*
	 * metodo que añade un punto ganador a un jugador
	 */
	protected void contabilizarPunto() {
		
		this.puntosGanadores++;
		
	}
	
	/*
	 * metodo que añade un error no forzado a un jugador
	 */
	protected void contabilizarError() {
		
		this.erroresNoForzados++;
		
	}
	
	/*
	 * metodo que añade un saque directo a un jugaor
	 */
	protected void contabilizarSaque() {
		
		this.saqueDirecto++;
		
	}
	
	/*
	 * metodo que compara el nombre introducido por teclado con en el nombre del jugador
	 */
	protected boolean mismoNombre(String nombre) {
		
		if ( this.nombre.equals(nombre) ) {
			return true;
		} else {
			return false;
		}
	}
	
}

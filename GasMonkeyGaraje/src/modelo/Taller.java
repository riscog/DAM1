package modelo;

import java.util.ArrayList;

public class Taller implements TallerInterface {

	// ATRIBUTOS
	
	ArrayList<Trabajo> trabajos;
	
	// CONSTRUCTORES
	
	public Taller() {
		this.trabajos = new ArrayList<Trabajo>();
	}
	
	// METODOS
	
	/*
	 * metodo que añade un trabajo a la lista de trabajos del taller
	 * 	Devuelve:
	 * 		-1 si el tipo de tabajo no es valido
	 * 		id del trabajo si se añade correctamente
	 */
	@Override
	public int anadirTrabajo(String tipoTrabajo, String descripcion) {
		
		int codigo = -1;
		Trabajo aux = null;
		
		if ( tipoTrabajo.equalsIgnoreCase("RM") ) {
			
			aux = new ReparacionMecanica(descripcion);
			this.trabajos.add(aux);
			codigo = aux.getId();
			
		} else if ( tipoTrabajo.equalsIgnoreCase("RCP") ) {
			
			aux = new ReparacionChapaYPintura(descripcion);
			this.trabajos.add(aux);
			codigo = aux.getId();
			
		} else if ( tipoTrabajo.equalsIgnoreCase("Revision") ) {
			
			aux = new Revision(descripcion);
			this.trabajos.add(aux);
			codigo = aux.getId();
			
		} else {
			codigo = -1;
		}
		return codigo;
	}
	
	/*
	 * sobrecarga del metodo anterior para añadir un trabajo de tipo Reparacion Electrica
	 */
	public int anadirTrabajo(String tipoTrabajo, String descripcion, String ingeniero, String maquina) {
		
		int codigo = -1;
		Trabajo aux = null;
		
		aux = new ReparacionElectrica(descripcion, ingeniero, maquina);
		this.trabajos.add(aux);
		codigo = aux.getId();
		
		return codigo;
	}
	
	/*
	 * metodo que comprueba si existe un trabajo
	 */
	private boolean existeTrabajo(int id) {
		
		boolean existe = false;
		
		for ( Trabajo t : trabajos ) {
			
			if ( t.getId() == id ) {
				existe = true;
			}
		}
		return existe;
	}
	
	/*
	 * metodo que devuelve el trabajo si lo encuentra en la lista
	 */
	private Trabajo encontrarTrabajo(int id) {
		
		Trabajo aux = null;
			
		for ( Trabajo t : trabajos ) {
				
			if ( t.getId() == id ) {
				aux = t;
			}
		}
		return aux; 
	}

	/*
	 * metodo que aumenta las horas de un trabajo
	 * 	Devuelve:
	 * 		0 si las horas son negativas
	 * 		-1 si el trabajo no existe
	 * 		-2 si el trabajo esta finalizado
	 * 		1 si aumentan correctamente
	 */
	@Override
	public int aumentarHoras(int id, int horas) {

		int codigo = 0;
		Trabajo aux = null;
		
		if ( horas <= 0 ) {
			codigo = 0;
		} else {
			
			if ( existeTrabajo(id) ) {
				
				aux = encontrarTrabajo(id);
				
				if ( !aux.isFinalizado() ) {
					
					aux.setNumeroHoras(horas);
					codigo = 1;
					
				} else {
					codigo = -2;
				}
				
			} else {
				codigo = -1;
			}
		}
		return codigo;
	}

	/*
	 * metodo que aumenta el coste de las piezas de un trabajo
	 * 	Devuelve:
	 * 		0 si el precio es negativo
	 * 		-1 si el trabajo no es una reparacion
	 * 		-2 si el trabajo esta finalizado
	 * 		-3 si el trabajo no existe
	 * 		1 si aumenta correctamente
	 */
	@Override
	public int aumentarCostePiezas(int id, double precio) {

		int codigo = 0;
		Trabajo aux = null;
		
		if ( precio <= 0 ) {
			codigo = 0;
		} else {
			
			if ( existeTrabajo(id) ) {
				
				aux = encontrarTrabajo(id);
				
				if ( aux instanceof Reparacion ) {
					
					if ( !aux.isFinalizado() ) {
						
						((Reparacion) aux).setPrecioMaterial(precio);
						codigo = 1;
						
					} else {
						codigo = -2;
					}
					
				} else {
					codigo = -1;
				}
				
			} else {
				codigo = -3;
			}
		}
		return codigo;
	}

	/*
	 * metodo que finaliza un trabajo
	 * 	Devuelve:
	 * 		0 si el trabajo esta finalizado
	 * 		-1 si no existe el trabajo
	 * 		1 si se finaliza correctamente
	 */
	@Override
	public int finalizarTrabajo(int id) {

		int codigo = 0;
		Trabajo aux = null;
		
		if ( existeTrabajo(id) ) {
			
			aux = encontrarTrabajo(id);
			
			if ( !aux.isFinalizado() ) {
				
				aux.setFinalizado();
				codigo = 1;
				
			} else {
				codigo = 0;
			}
			
		} else {
			codigo = -1;
		}
		return codigo;
	}

	/*
	 * metodo que muestra un trabajo segun un id pasado por parametro
	 */
	@Override
	public String muestraTrabajo(int id) {

		String codigo = "";
		Trabajo aux = null;
		
		if ( existeTrabajo(id) ) {
			
			aux = encontrarTrabajo(id);
			codigo = aux.toString();
			
		} else {
			codigo = "No existe un trabajo con ese identificador.\n";
		}
		return codigo;
	}
	
	/*
	 * metodo que elimina un trabajo de la lista
	 * 	Devuelve:
	 * 		-1 si el trabajo no existe
	 * 		1 si se elimina correctamente
	 */
	public int borrarTrabajo(int id) {
		
		int codigo = 0;
		Trabajo aux = null;
		
		if ( existeTrabajo(id) ) {
			
			aux = encontrarTrabajo(id);
			this.trabajos.remove(aux);
			codigo = 1;
			
		} else {
			codigo = -1;
		}
		return codigo;
	}
	
}

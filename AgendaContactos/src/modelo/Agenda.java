package modelo;
public class Agenda {

	//ATRIBUTOS
	
	Contacto lista[];
	
	//CONSTRUCTORES
	
	public Agenda() {
		this.lista = new Contacto[100];
	}
	
	//METODOS
	
	/*
	 * metodo que permite conocer la posicion del contacto introducido por teclado
	 * en el array de contactos de la agenda
	 */
	private int posicionContacto(String nombre) {
		
		//Contacto contacAuxi = new Contacto(nombre);
		
		int contador = 0;
		
		for ( contador = 0; contador < this.lista.length; contador++ ) {
			
			if ( this.lista[contador].getNombre().equals(nombre) ) {
				break;
			}
		}
		return contador;
	}
	
	/*
	 * metodo que permite conocer si un contacto ya existe en la agenda
	 */
	public boolean existe(String nombre) {
		
		boolean existe = false;
		
		for ( int contador = 0; contador < this.lista.length && !existe; contador++ ) {
			
			if ( this.lista[contador].getNombre().equals(nombre) ) {
				existe = true;
			}
		}
		return existe;
	}
	
	/*
	 * metodo que añade un contacto en el array de contactos de la agenda
	 */
	public void añadirContacto(String nombre, String correo, int telefono) {
		
		for ( int contador = 0; contador < this.lista.length; contador++ ) {
			
			if ( this.lista[contador] == null ) {
				this.lista[contador] = new Contacto(nombre, correo, telefono);
				break;
			}
		}
	}
	
	/*
	 * metodo que elimina un contacto de la agenda
	 */
	public void eliminarContacto(String nombre) {
		
		this.lista[posicionContacto(nombre)] = null;
		
	}
	
	/*
	 * metodo que busca un alumno en la agenda y muestra su informacion por pantalla
	 */
	public String buscarContacto(String nombre) {
		
		return this.lista[posicionContacto(nombre)].toString();
		
	}
	
	/*
	 * metodo que muestra por pantalla todos los nombres de la agenda
	 */
	public String mostrarContactos() {
		
		String lista = "LISTA DE CONTACTOS";
		lista += "------------------";
		
		for ( int contador = 0; contador < this.lista.length; contador++ ) {
			
			if ( this.lista[contador] != null ) {
				lista += this.lista[contador].toString() + "\n";	
			}
		}
		return lista;
	}
	
	/*
	 * metodo que permite modificar el correo de un contacto
	 */
	public void modificarCorreo(String nombre, String correo) {
		
		this.lista[posicionContacto(nombre)].setCorreo(correo);
		
	}
	
	/*
	 * metodo que permite modificar el correo de un contacto
	 */
	public void modificarTelefono(String nombre, int telefono) {
		
		this.lista[posicionContacto(nombre)].setTelefono(telefono);
		
	}
	
	/*
	 * metodo que muestra por pantalla la cantidad de contactos que hay en la agenda
	 */
	public int cantidadContactos() {
		
		int cantidad = 0;
		
		for ( int contador = 0; contador < this.lista.length; contador++ ) {
			
			if ( this.lista[contador] != null ) {
				cantidad++;	
			}
		}
		return cantidad;
	}
	
}

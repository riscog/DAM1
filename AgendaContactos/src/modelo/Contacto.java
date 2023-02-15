package modelo;
public class Contacto {

	//ATRIBUTOS
	
	String nombre, correo;
	int telefono;
	
	//CONSTRUCTORES
	
	public Contacto() {}
	
	public Contacto(String nombre, String correo, int telefono) {
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
	}
	
	//GETTERS Y SETTERS
	
	public String getNombre() {
		return nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	//METODOS
	
	/*
	 * metodo toString que muestra por pantalla la informacion de un contacto
	 */
	@Override
	public String toString() {
		return nombre + " | Correo electronico: " + correo + " | Telefono: " + telefono;
	}
	
}

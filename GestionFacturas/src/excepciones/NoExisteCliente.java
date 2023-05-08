package excepciones;

public class NoExisteCliente extends Exception {

	private String error;
	
	public NoExisteCliente() {
		this.error = "No existe un cliente con ese DNI en el sistema\n";
	}

	@Override
	public String toString() {
		return error;
	}
	
}

package excepciones;

public class NoExisteProducto extends Exception {

	private String error;
	
	public NoExisteProducto() {
		this.error = "No existe ese producto en el sistema\n";
	}

	@Override
	public String toString() {
		return error;
	}
	
}

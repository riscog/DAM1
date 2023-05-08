package excepciones;

public class YaExisteCliente extends Exception {

	private String error;
	
	public YaExisteCliente() {
		this.error = "El cliente ya existe en el sistema\n";
	}

	@Override
	public String toString() {
		return error;
	}
	
}

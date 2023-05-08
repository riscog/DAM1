package excepciones;

public class YaExisteProducto extends Exception{

	private String error;
	
	public YaExisteProducto() {
		this.error = "El producto ya existe en el sistema\n";
	}

	@Override
	public String toString() {
		return error;
	}
	
}

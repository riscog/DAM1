package excepciones;

public class NoExisteFactura extends Exception {

	private String error;
	
	public NoExisteFactura() {
		this.error = "No existe una factura con ese numero en el sistema\n";
	}

	@Override
	public String toString() {
		return error;
	}
	
}

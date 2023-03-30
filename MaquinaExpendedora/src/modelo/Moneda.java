package modelo;

public class Moneda {

	// ATRIBUTOS
	
	final private int valor;
	
	// CONSTRUCTORES
		
	protected Moneda(int valor) {
		this.valor = valor;
	}
		
	// GETTERS Y SETTERS
		
	protected int getValor() {
		return valor;
	}	
		
	// METODOS

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moneda other = (Moneda) obj;
		return valor == other.valor;
	}

	@Override
	public String toString() {
		return "moneda de " + valor;
	}
	
	
	
}

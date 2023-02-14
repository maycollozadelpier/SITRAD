package detel.copere.ejercito.mil.pe.util.paginator;

public class PageItem {

	private int numero;
	private boolean actual;
	
	public PageItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageItem(int numero, boolean actual) {
		this.numero = numero;
		this.actual = actual;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean isActual() {
		return actual;
	}
	public void setActual(boolean actual) {
		this.actual = actual;
	}
	
}

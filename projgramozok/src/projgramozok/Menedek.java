package projgramozok;

public abstract class Menedek {
	protected Tabla tabla;
	
	public Menedek(Tabla t) {
		this.tabla = t;
	}
	public abstract void destroy();
	
}

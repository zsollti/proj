package projgramozok;
/**Absztrakt mened�k �soszt�ly. A t�bl�n lehet egy darab.
 *
 */
public abstract class Menedek {
	protected Tabla tabla;
	
	public Menedek(Tabla t) {
		this.tabla = t;
	}
	public abstract void destroy();
	
}

package projgramozok;
/**Absztrakt menedék õsosztály. A táblán lehet egy darab.
 *
 */
public abstract class Menedek {
	protected Tabla tabla;
	
	public Menedek(Tabla t) {
		this.tabla = t;
	}
	public abstract void destroy();
	
}

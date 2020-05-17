package projgramozok;
/**Absztrakt mened�k �soszt�ly. A t�bl�n lehet egy darab.
 *
 */
public abstract class Menedek implements Rajzolhato{
	/**
	 *A t�bla amelyen a mened�k elhelyezkedik.
	 */
	protected Tabla tabla;
	
	/**
	 *Konstruktor
	 *@param t A t�bla ahova fel�l�tjuk a mened�ket
	 */
	public Menedek(Tabla t) {
		this.tabla = t;
	}
	
	/**
	 *Absztrakt f�ggv�ny, a mened�k megsemmis�t�s�hez.
	 */
	public abstract void destroy();
	
	public abstract void rajzol(int xpos, int ypos);

}

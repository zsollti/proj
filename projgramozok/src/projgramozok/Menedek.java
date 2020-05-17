package projgramozok;
/**Absztrakt menedék õsosztály. A táblán lehet egy darab.
 *
 */
public abstract class Menedek implements Rajzolhato{
	/**
	 *A tábla amelyen a menedék elhelyezkedik.
	 */
	protected Tabla tabla;
	
	/**
	 *Konstruktor
	 *@param t A tábla ahova felálítjuk a menedéket
	 */
	public Menedek(Tabla t) {
		this.tabla = t;
	}
	
	/**
	 *Absztrakt függvény a menedék megsemmisítéséhez.
	 */
	public abstract void destroy();
	/**
	 * Absztrakt rajzolófüggvény
	 * @param xpos - az x pozíciója az objektumnak
	 * @param ypos - az y pozíció
	 */
	public abstract void rajzol(int xpos, int ypos);

}

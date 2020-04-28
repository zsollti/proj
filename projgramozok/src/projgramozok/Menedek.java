package projgramozok;
/**Absztrakt menedék õsosztály. A táblán lehet egy darab.
 *
 */
public abstract class Menedek {
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
	 *Absztrakt függvény, a menedék megsemmisítéséhez.
	 */
	public abstract void destroy();
	
}
